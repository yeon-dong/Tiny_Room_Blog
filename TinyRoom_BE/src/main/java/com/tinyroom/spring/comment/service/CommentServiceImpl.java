package com.tinyroom.spring.comment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.comment.dao.CommentDao;
import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.comment.dto.CommentDto;
import com.tinyroom.spring.comment.dto.ResponseCommentDto;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.service.PostService;

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

//	@Override
//	public List<Comment> getCommentList(int post_id) {
//		 List<Comment> comments = commentDao.findByPostPost_Id(post_id);
//		return comments;
//	}
}
