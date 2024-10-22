package com.tinyroom.spring.post.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinyroom.spring.member.controller.MemberController;
import com.tinyroom.spring.post.dto.PageRequestDto;
import com.tinyroom.spring.post.dto.PageResponseDto;
import com.tinyroom.spring.post.dto.PostDto;
import com.tinyroom.spring.post.service.PostService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
@RequestMapping("/posts")
public class PostController {
	@Autowired
	PostService postService;
	
	// '/member' 내가 쓴 글 조회 '/main' 메인페이지 글 조회
	
	//메인페이지 전체 글 조회 (최신순 나열)
	//PageNation 적용
//	@GetMapping("/list/recently")
//	public PageResponseDto<PostDto> list(PageRequestDto pageRequestDto){
//		log.info(pageRequestDto);
//		
//		return postService.getList(pageRequestDto);
//		
//	}
//	
	
	
	
	
	//category number 1 : 주방/가전제품, 2 : 홈 인테리어, 3 : 실내가구, 4: 전자제품
	// 내가 쓴 글 상세조회
	// http://localhost:8080/posts/member/1
	@GetMapping("/member/{post_id}") 
	public PostDto get(
			@PathVariable(name="post_id") int post_id
			) {
		return postService.get(post_id);
	}
	
	//내가 쓴 글 수정
	@PutMapping("/member/{post_id}") 
	public  Map<String, String> modify(
			@PathVariable(name="post_id") int post_id,
			@RequestBody PostDto postDto
			) {
		
		postDto.setPost_id(post_id);
		postService.modify(postDto);
		return Map.of("result", "success");
	}
	
	//내가 쓴 글 삭제
	@DeleteMapping("/member/{post_id}")
	public Map<String, String> remove(
			@PathVariable(name="/member/{post_id}") int post_id
			){
		postService.remove(post_id);
		return Map.of("result", "success");
	}
}
