package com.tinyroom.spring.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tinyroom.spring.post.dao.PostDao;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;
import com.tinyroom.spring.post.dto.PageResponseDto;
import com.tinyroom.spring.post.dto.PostDto;


public interface PostService {
	public PostDto get(int post_id);
	public void modify(PostDto postDto);
	public void remove(int post_id);
	
	public PageResponseDto<PostDto> getList(PageRequestDto pageRequestDto);
	
	default PostDto entityPostDto(Post post) {
		PostDto postDto = PostDto.builder()
				.post_id(post.getPost_id())
				.member(post.getMember())
				.category(post.getCategory())
				.date(post.getDate())
				.w_date(post.getW_date())
				.title(post.getTitle())
				.content(post.getContent())
				.post_img(post.getPost_img())
				.is_active(post.getIs_active())
				.build();
		return postDto;
	}
	
}
