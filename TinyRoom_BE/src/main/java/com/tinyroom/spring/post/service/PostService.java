package com.tinyroom.spring.post.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tinyroom.spring.post.dao.PostDao;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;
import com.tinyroom.spring.post.dto.PageResponseDto;
import com.tinyroom.spring.post.dto.PostDto;


public interface PostService {
	public PostDto get(int post_id);
	public void modify(PostDto postDto, List<MultipartFile> post_img_files);
	public void remove(int post_id);
	public int postWrite(Post post, List<MultipartFile> post_img_files);
	
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
				.thumbnail(post.getThumbnail())
				.content_for_html(post.getContent_for_html())
				.build();
		return postDto;
	}
	
	default Post dtoToEntity(PostDto postDto) {
		Post post = Post.builder()
				.post_id(postDto.getPost_id())
				.member(postDto.getMember())
				.category(postDto.getCategory())
				.date(postDto.getDate())
				.w_date(postDto.getW_date())
				.title(postDto.getTitle())
				.content(postDto.getContent())
				.post_img(postDto.getPost_img())
				.is_active(postDto.getIs_active())
				.thumbnail(postDto.getThumbnail())
				.content_for_html(postDto.getContent_for_html())
				.build();
		return post;
	}
	
	public void modifyForDelete(PostDto postDto);
    public Optional<Post> findById(int post_id);
	
}
