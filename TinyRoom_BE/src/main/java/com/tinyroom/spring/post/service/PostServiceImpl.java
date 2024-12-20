package com.tinyroom.spring.post.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tinyroom.spring.blog.dto.PostPageDto;
import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.service.MemberServiceImpl;
import com.tinyroom.spring.post.dao.PostDao;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;
import com.tinyroom.spring.post.dto.PageResponseDto;
import com.tinyroom.spring.post.dto.PostDto;
import com.tinyroom.spring.post.dto.ResponsePostMainDto;
import com.tinyroom.spring.post.dto.ResponsePostRecommendDto;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class PostServiceImpl implements PostService {	
	@Autowired
	private PostDao postDao;
	
	@Override
	public PostDto get(int post_id) {
		
		Optional<Post> result = postDao.findById(post_id);
		Post post = result.orElseThrow();

		return entityPostDto(post);
	}

	@Override
	public void remove(int post_id) {
		postDao.deleteById(post_id);		
	}


	@Override
	public PageResponseDto<PostDto> getList(PageRequestDto pageRequestDto) {
		Page<Post> result = postDao.search1(pageRequestDto);
		
		List<PostDto> dtoList = result.get().map(post -> entityPostDto(post)).collect(Collectors.toList());
		
		PageResponseDto<PostDto> responseDto = PageResponseDto.<PostDto>withAll()
				.dtoList(dtoList)
				.pageRequestDto(pageRequestDto)
				.total(result.getTotalElements())
				.build();
		
		return responseDto;
	}

	@Override
	public int postWrite(Post post) {
	    // 포스트 저장
	    postDao.save(post);
	    return post.getPost_id();
	}

	@Override
	public void modify(PostDto postDto) {
		Optional<Post> result = postDao.findById(postDto.getPost_id());
		Post post = result.orElseThrow();

		post.changeCategory(postDto.getCategory());
		post.changeContent(postDto.getContent());
		post.changeDate(postDto.getDate());
		post.changeTitle(postDto.getTitle());
		post.setW_date(postDto.getW_date());
		post.setText_content(postDto.getText_content());
		post.setThumbnail(postDto.getThumbnail());
		postDao.save(post);
	}

	@Override
	public void modifyForDelete(PostDto postDto) {
		Optional<Post> result = postDao.findById(postDto.getPost_id());
		Post post = result.orElseThrow();
		
		post.setIs_active(0);
		postDao.save(post);
	}
	
    public Optional<Post> findById(int post_id) {
        return postDao.findById(post_id); // Optional<Post> 반환
    }

	@Override
	public List<Post> findTopByOrderByHeartCountDesc(PageRequest of) {
		return postDao.findTopByOrderByHeartCountDesc(PageRequest.of(0, 3));
	}

	@Override

	public List<ResponsePostMainDto> getPosts(int category, int page) {
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "w_date"));
		Page<ResponsePostMainDto> postPage = postDao.findByConditions(category, pageable);
		
		return postPage.getContent();
	}

	@Override
	public int countPosts(int category) {
		int count = postDao.countByConditions(category);
		
		return count;
	}

	public List<Post> getCalendarList(int year, int month, int member_id) {
		return postDao.findByYearAndMonthAndMember(year, month, member_id);

	}
	

}
