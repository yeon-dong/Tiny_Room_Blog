package com.tinyroom.spring.post.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.tinyroom.spring.category.dto.CategoryDto;
import com.tinyroom.spring.category.service.CategoryService;
import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.comment.service.CommentService;
import com.tinyroom.spring.member.controller.MemberController;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.member.service.MemberService;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;
import com.tinyroom.spring.post.dto.PageResponseDto;
import com.tinyroom.spring.post.dto.PostDto;
import com.tinyroom.spring.post.dto.RequestPostUpdateDto;
import com.tinyroom.spring.post.dto.ResponsePostDetailDto;
import com.tinyroom.spring.post.service.PostService;
import com.tinyroom.spring.postheart.service.PostheartService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
@RequestMapping("/posts")
public class PostController {
	@Autowired
	PostService postService;
	
	@Autowired
	PostheartService postheartService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	CategoryService categoryService;
	
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
	// http://localhost:8080/posts/postDetail/1
	@GetMapping("/postDetail") 
	public ResponsePostDetailDto get(
			@RequestParam(name="post_id") int post_id
			) {
		PostDto postDto = postService.get(post_id);
		Post post = postService.dtoToEntity(postDto);
		int heartCount = postheartService.getCount(post);
		List<Comment> comments= commentService.findAll(post_id);
		
		ResponsePostDetailDto responseDto = ResponsePostDetailDto.builder()
			    .post(post)
			    .heartCount(heartCount)
			    .comment(comments)
			    .build();
		
		return responseDto;
	}
	
	//내가 쓴 글 수정
	@PutMapping("/postUpdate") 
	public Map<String, String> modify(
			@RequestParam(name="post_id") int post_id,
	        @RequestBody RequestPostUpdateDto requestPostUpdateDto
	        ) {
	    PostDto postDto = postService.get(post_id);
	    
	    int category_id = requestPostUpdateDto.getCategory_id();
	    CategoryDto categoryDto = categoryService.get(category_id);
	    Category category = categoryService.dtoToEntity(categoryDto);
	    
	    String dateString = requestPostUpdateDto.getDate();
	    
	    // DateTimeFormatter를 사용하여 LocalDate로 변환
	    if (dateString != null && !dateString.isEmpty()) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate localDate = LocalDate.parse(dateString, formatter);
	        postDto.setDate(localDate);  
	    }

	    String title = requestPostUpdateDto.getTitle();
	    String content = requestPostUpdateDto.getContent();
	    String post_img = requestPostUpdateDto.getPost_img();
	    
	    if (title != null) postDto.setTitle(title);
	    if (content != null) postDto.setContent(content);
	    if (post_img != null) postDto.setPost_img(post_img);
	    if (category != null) postDto.setCategory(category);
	    
	    postService.modify(postDto);
	    
	    return Map.of("result", "success");
	}
	
	
	//내가 쓴 글 삭제
	// http://localhost:8080/posts/delete/1
	@PutMapping("/delete")
	public Map<String, String> remove(
		@RequestParam(name="post_id") int post_id
			){
		PostDto postDto = postService.get(post_id);
		postDto.setIs_active(1); //삭제 시, is_activce = 1
		
		postService.modify(postDto); //remove가 아닌 is_active로 상태를 변경
		return Map.of("result", "success");
	}
	
//	//새로운 글 작성
//	@PostMapping("/member/write")
//	public Map<String, Integer> register(
//			@RequestBody HashMap<String, Object> map,
//			@RequestParam(name="email") String email
//			){
//		LocalDate date;
//		//Category category = category
//		
//	    String dateString = (String) map.get("date");
//	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//	    date = LocalDate.parse(dateString, formatter);
//	    
//	    LocalDate w_date = LocalDate.now();
//	    
//		String title = (String) map.get("title");
//	    String content = (String)map.get("content");
//	    String post_img = (String)map.get("post_img");
//	    
//		MemberDto member = memberService.getMember(email);
//		Map<String, Object> post = new HashMap<>();
//		
//		post.put("member", member);
//		//post.put("category", category);
//		post.put("date", date);
//		post.put("w_date", w_date);
//		post.put("title", title);
//		post.put("content", content);
//		post.put("post_img", post_img);
//		post.put("is_active", 0);
//		
//		int post_id = postService.postWrite(post);
//		
//		return Map.of("No",post_id);
//	}
	
	
	
}
