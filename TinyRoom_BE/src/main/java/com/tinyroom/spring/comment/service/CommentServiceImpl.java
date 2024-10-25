package com.tinyroom.spring.comment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.comment.dao.CommentDao;
import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.comment.dto.CommentDto;
import com.tinyroom.spring.comment.dto.ResponseChildren;
import com.tinyroom.spring.comment.dto.ResponseCommentDto;
import com.tinyroom.spring.comment.dto.ResponseCommentListDto;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.service.PostService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentDao commentDao;
	
	@Override
	public List<Comment> findAll(Post post) {
		// TODO Auto-generated method stub
		return commentDao.findByPost(post);
	}

	@Override
	public void addComment(Comment comment) {
		 System.out.println("service");
		commentDao.save(comment);
	}

	@Override
	public CommentDto getComment(int comment_id) {
		Optional<Comment> result = commentDao.findById(comment_id);
		Comment comment = result.orElseThrow();
		return entityCommentDto(comment);
	}

	@Override
	public void modify(CommentDto commentDto) {
		Comment comment = dtoToEntity(commentDto);
		
		commentDao.save(comment);
	}

	@Override
	public void delete(int comment_id) {
		commentDao.deleteById(comment_id);
	}

	@Override
	public int getCount(Post post) {
		return commentDao.countByPost(post);
	}

    public List<ResponseCommentDto> getCommentsByPost(Post post) {
        List<Comment> comments = commentDao.findByPostOrderByDateDesc(post);
        Map<Integer, ResponseCommentDto> commentMap = new HashMap<>();

        // 모든 댓글을 ResponseCommentDto로 변환하고 맵에 저장
        for (Comment comment : comments) {
            ResponseCommentDto dto = new ResponseCommentDto();
            dto.setComment_id(comment.getComment_id());
            dto.setContent(comment.getContent());
            dto.setPost_id(post.getPost_id());
            dto.setDate(comment.getDate());
            dto.setParent_id(comment.getParent() != null ? comment.getParent().getComment_id() : 0); // 부모 ID 설정

            commentMap.put(dto.getComment_id(), dto);
        }

        // 자식 댓글을 부모 댓글에 추가
        for (ResponseCommentDto dto : commentMap.values()) {
            if (dto.getParent_id() != 0) { // 부모 댓글이 있는 경우
                ResponseCommentDto parentDto = commentMap.get(dto.getParent_id());
                if (parentDto != null) {
                    if (parentDto.getChildren() == null) {
                        parentDto.setChildren(new ArrayList<>());
                    }
                    parentDto.getChildren().add(dto); // 부모 댓글의 자식 리스트에 추가
                }
            }
        }

        // 부모 댓글만 포함된 리스트 생성
        List<ResponseCommentDto> parentComments = new ArrayList<>();
        for (ResponseCommentDto dto : commentMap.values()) {
            if (dto.getParent_id() == 0) { // 부모 댓글만 추가
                parentComments.add(dto);
            }
        }

        return parentComments; // 부모-자식 구조의 리스트 반환
    }

	@Override
	public List<ResponseCommentListDto> getCommentsList(int postId, int page) {
		
		log.info("################################## getCommentsList 실행 ########################################");
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "date"));
		Page<ResponseCommentListDto> parentComments = commentDao.findParentComments(postId, pageable);

		log.info("################################## " + parentComments.getContent() + " ########################################");
		
	    for (ResponseCommentListDto parent : parentComments.getContent()) {
	        List<ResponseChildren> children = commentDao.findChildrenComments(parent.getCommentId());
	        parent.setChildren(children);
	    }
		
		return parentComments.getContent();
	}

	@Override
	public int countParent(int postId) {
		int count = commentDao.countByCondition(postId);
		
		return count;
	}

}
