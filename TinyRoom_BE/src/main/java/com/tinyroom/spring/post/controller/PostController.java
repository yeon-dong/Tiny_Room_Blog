package com.tinyroom.spring.post.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.tinyroom.spring.post.dto.RequestPostWriteDto;
import com.tinyroom.spring.post.dto.ResponsePostDetailDto;
import com.tinyroom.spring.post.service.PostService;
import com.tinyroom.spring.postheart.service.PostheartService;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${file.upload-dir}") // 업로드 디렉토리 경로
    private String uploadDir;
	
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
	
	//내가 쓴 글 전체조회
//	@GetMapping("/myPostAll")
//	public List<PostDto> getMyPosts(){
//		
//		
//		
//	}
	
	
	
	// 내가 쓴 글 상세조회
	// http://localhost:8080/posts/postDetail/1
	@GetMapping("/postDetail") 
	public ResponsePostDetailDto get(
			@RequestParam(name="post_id") int post_id
			) {
		PostDto postDto = postService.get(post_id);
		Post post = postService.dtoToEntity(postDto);
		int heartCount = postheartService.getCount(post);
		int commentCount = commentService.getCount(post);

		
		ResponsePostDetailDto responseDto = ResponsePostDetailDto.builder()
			    .post(post)
			    .heartCount(heartCount)
			    .commentCount(commentCount)
			    .build();
		
		return responseDto;
	}
	

	//내가 쓴 글 수정
	@PutMapping("/postUpdate") 
	public Map<String, String> modify(
			@RequestParam(name="post_id") int post_id,
			@RequestParam("date") String dateString,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("category_id") int category_id,
			@RequestParam("text_content") String text_content,
			@RequestParam("thumbnail") String thumbnail
			
	        ) {
	    PostDto postDto = postService.get(post_id);
	    
	    CategoryDto categoryDto = categoryService.get(category_id);
	    Category category = categoryService.dtoToEntity(categoryDto);
	    
	    
	    // DateTimeFormatter를 사용하여 LocalDate로 변환
	    if (dateString != null && !dateString.isEmpty()) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate localDate = LocalDate.parse(dateString, formatter);
	        postDto.setDate(localDate);  
	    }
	    
	    if (title != null) postDto.setTitle(title);
	    if (content != null) postDto.setContent(content);
	    if (category != null) postDto.setCategory(category);
	    
	    LocalDate w_date = LocalDate.now(); 
	    postDto.setW_date(w_date);
	    postDto.setText_content(text_content);
	    postDto.setThumbnail(thumbnail);
	    
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
		
		postService.modifyForDelete(postDto); //remove가 아닌 is_active로 상태를 변경
		return Map.of("result", "success");
	}
	
	//새로운 글 작성
	@PostMapping("/writePost")
	public Map<String, Integer> writePost(
			@RequestParam("date") String dateString,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("category_id") int category_id,
			@RequestParam("text_content") String text_content,
			@RequestParam("thumbnail") String thumbnail
	) {
	    // 로그인된 사용자 이메일 추출
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName(); // username 추출

	    LocalDate date; // LocalDate로 선언

	    
	    // 날짜 문자열을 LocalDate로 변환
	    try {
	        date = LocalDate.parse(dateString); // 기본 ISO 형식으로 파싱
	    } catch (DateTimeParseException e) {
	        throw new IllegalArgumentException("Invalid date format: " + dateString);
	    }

	    LocalDate w_date = LocalDate.now(); // 작성일 설정
	    
	    CategoryDto categoryDto = categoryService.get(category_id);
	    Category category = categoryService.dtoToEntity(categoryDto);

	    MemberDto memberDto = memberService.getMember(email);
	    Member member = memberService.dtoToEntity(memberDto);

	    // Post 객체 생성
	    Post post = Post.builder()
	            .member(member)      // Member 객체를 설정
	            .category(category)  // Category 객체를 설정
	            .date(date)         // 날짜 설정
	            .w_date(w_date)     // 작성일 설정
	            .title(title)       // 제목 설정
	            .content(content)    // 내용 설정 
	            .text_content(text_content)
	            .thumbnail(thumbnail)
	            .is_active(1)       // 활성화 상태 설정 (예: 1 = 활성)
	            .build();

	    int post_id = postService.postWrite(post);

	    return Map.of("No", post_id);
	}


	
	
	
}
