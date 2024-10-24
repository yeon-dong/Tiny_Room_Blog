package com.tinyroom.spring.postheart.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.member.service.MemberService;
import com.tinyroom.spring.post.controller.PostController;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PostDto;
import com.tinyroom.spring.post.service.PostService;
import com.tinyroom.spring.postheart.domain.PostHeart;
import com.tinyroom.spring.postheart.dto.PostheartDto;
import com.tinyroom.spring.postheart.service.PostheartService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
@RequestMapping("/hearts")
public class PostheartController {
	@Autowired
	PostheartService postheartService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/view")
	public int viewHeart(
		@RequestParam(name="post_id") int post_id) {
		PostDto postDto = postService.get(post_id);
		Post post = postService.dtoToEntity(postDto);
		
	    // 로그인된 사용자 이메일 추출
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName(); // username 추출
	    
	    MemberDto memberDto = memberService.getMember(email);
	    Member member = memberService.dtoToEntity(memberDto);
	    
	    PostheartDto postheartDto = postheartService.getHeart(member, post);
		
	    if(postheartDto == null) 
	    	return 0;
	    
		return 1;
	}
	
	
	@GetMapping("/add")
	public Map<String, String> addHeart(
			@RequestParam(name="post_id") int post_id
			){
		PostDto postDto = postService.get(post_id);
		Post post = postService.dtoToEntity(postDto);
		
	    // 로그인된 사용자 이메일 추출
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName(); // username 추출
	    
	    MemberDto memberDto = memberService.getMember(email);
	    Member member = memberService.dtoToEntity(memberDto);
	    
	    PostHeart postHeart = PostHeart.builder()
	    		.member(member)
	    		.post(post)
	    		.build();
	    		;
	    		
	    postheartService.addHeart(postHeart);
		
		return Map.of("result", "success");
	}
	
	@DeleteMapping("/delete")
	public Map<String, String> deleteHeart(
			@RequestParam(name="post_id") int post_id
			){
		PostDto postDto = postService.get(post_id);
		Post post = postService.dtoToEntity(postDto);
		
	    // 로그인된 사용자 이메일 추출
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName(); // username 추출
	    
	    MemberDto memberDto = memberService.getMember(email);
	    Member member = memberService.dtoToEntity(memberDto);
	    
	    PostheartDto postheartDto = postheartService.getHeart(member, post);
	    		
	    postheartService.deleteHeart(postheartDto.getPost_heart_id());
		
		return Map.of("result", "success");
	}
	
}
