package com.tinyroom.spring.post.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.member.controller.MemberController;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.member.service.MemberService;
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
	
	@Autowired
	MemberService memberService;
	
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
		System.out.println("postmapping");
		return postService.get(post_id);
	}
	
	//내가 쓴 글 수정
	@PutMapping("/member/{post_id}") 
	public Map<String, String> modify(
	        @PathVariable(name="post_id") int post_id,
	        @RequestBody HashMap<String, Object> map 
	        ) {
	    PostDto postDto = get(post_id);
	    
	    Category category = (Category)map.get("category");
	    String dateString = (String) map.get("date");
	    
	    // DateTimeFormatter를 사용하여 LocalDate로 변환
	    if (dateString != null && !dateString.isEmpty()) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate localDate = LocalDate.parse(dateString, formatter);
	        postDto.setDate(localDate);  
	    }

	    String title = (String) map.get("title");
	    String content = (String) map.get("content");
	    String post_img = (String) map.get("post_img");
	    
	    if (title != null) postDto.setTitle(title);
	    if (content != null) postDto.setContent(content);
	    if (post_img != null) postDto.setPost_img(post_img);
	    if (category != null) postDto.setCategory(category);
	    
	    postService.modify(postDto);
	    
	    return Map.of("result", "success");
	}
	
	//내가 쓴 글 삭제
	@DeleteMapping("/member/{post_id}")
	public Map<String, String> remove(
			@PathVariable(name="post_id") int post_id
			){
		
		postService.remove(post_id);
		return Map.of("result", "success");
	}
	
	//새로운 글 작성
	@PostMapping("/member/write")
	public Map<String, Integer> register(
			@RequestBody HashMap<String, Object> map,
			@RequestParam(name="email") String email
			){
		LocalDate date;
		//Category category = category
		
	    String dateString = (String) map.get("date");
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    date = LocalDate.parse(dateString, formatter);
	    
	    LocalDate w_date = LocalDate.now();
	    
		String title = (String) map.get("title");
	    String content = (String)map.get("content");
	    String post_img = (String)map.get("post_img");
	    
		MemberDto member = memberService.getMember(email);
		Map<String, Object> post = new HashMap<>();
		
		post.put("member", member);
		post.put("category", category);
		post.put("date", date);
		post.put("w_date", w_date);
		post.put("title", title);
		post.put("content", content);
		post.put("post_img", post_img);
		post.put("is_active", 0);
		
		int post_id = postService.postWrite(post);
		
		return Map.of("No",post_id);
	}
	
	
	
}
