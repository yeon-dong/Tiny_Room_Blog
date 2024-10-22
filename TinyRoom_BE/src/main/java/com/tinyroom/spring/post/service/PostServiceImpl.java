package com.tinyroom.spring.post.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.post.dao.PostDao;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;
import com.tinyroom.spring.post.dto.PageResponseDto;
import com.tinyroom.spring.post.dto.PostDto;

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
	public void modify(PostDto postDto) {
		Optional<Post> result = postDao.findById(postDto.getPost_id());
		Post post = result.orElseThrow();
		
		post.changeCategory(postDto.getCategory());
		post.changeContent(postDto.getContent());
		post.changeDate(postDto.getDate());
		post.changePost_img(postDto.getPost_img());
		post.changeTitle(postDto.getTitle());
		
		postDao.save(post);
		
	}

	@Override
	public void remove(int post_id) {
		System.out.println("postService -> remove");
		postDao.deleteById(post_id);		
	}

	@Override
	public PageResponseDto<PostDto> getList(PageRequestDto pageRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public PageResponseDto<PostDto> getList(PageRequestDto pageRequestDto) {
//		Page<Post> result = postDao.search1(pageRequestDto);
//		
//		List<PostDto> dtoList = result.get().map(post -> entityPostDto(post)).collect(Collectors.toList());
//		
//		PageResponseDto<PostDto> responseDto = PageResponseDto.<PostDto>withAll()
//				.dtoList(dtoList)
//				.pageRequestDto(pageRequestDto)
//				.total(result.getTotalElements())
//				.build();
//		
//		return responseDto;
//	}

}
