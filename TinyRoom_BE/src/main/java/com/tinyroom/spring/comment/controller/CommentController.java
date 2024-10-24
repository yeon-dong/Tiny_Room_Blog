package com.tinyroom.spring.comment.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.comment.dto.CommentDto;
import com.tinyroom.spring.comment.dto.ResponseCommentDto;
import com.tinyroom.spring.comment.service.CommentService;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.member.service.MemberService;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PostDto;
import com.tinyroom.spring.post.service.PostService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PostService postService;
	
	@GetMapping("/view")
	public List<ResponseCommentDto> viewCommentList(
			@RequestParam(name="post_id") int post_id
			){
		PostDto postDto = postService.get(post_id);
		Post post = postService.dtoToEntity(postDto);
		List<Comment> commentList = commentService.findAll(post);
	    List<ResponseCommentDto> responseCommentDtos = new ArrayList<>();
	    for (Comment comment : commentList) {
	        ResponseCommentDto responseDto = new ResponseCommentDto();
	        responseDto.setComment_id(comment.getComment_id());
	        responseDto.setContent(comment.getContent());
	        responseDto.setNickname(comment.getMember().getNickname()); // Assuming Member has a getNickname() method
	        responseDto.setDate(comment.getDate());
	        responseDto.setMember_id(comment.getMember().getMember_id());
	        responseDto.setPost_id(comment.getPost().getPost_id());

	        responseCommentDtos.add(responseDto);
	    }

		
		return responseCommentDtos;
	}

	@PostMapping("/writeComment")
	public Map<String, String> writeComment(
			@RequestParam(name="post_id") int post_id,
			@RequestParam(name="content") String content
			){
		
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName(); // username 추출
	    
	    MemberDto memberDto = memberService.getMember(email);
	    Member member = memberService.dtoToEntity(memberDto);
	    
	    PostDto postDto = postService.get(post_id);
		Post post = postService.dtoToEntity(postDto);
	    
	    LocalDate date = LocalDate.now(); 
//	    
	    Comment comment = Comment.builder()
	    		.member(member)
	    		.post(post)
	    		.content(content)
	    		.date(date)
	    		.build();
	    
	    commentService.addComment(comment);
	    System.out.println("controller");
	    return Map.of("result", "success");
	}
	
	@PutMapping("/updateComment")
	public Map<String, String> updateComment(
			@RequestParam(name="comment_id") int comment_id,
			@RequestParam(name="content") String content
			){
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  String email = auth.getName(); // username 추출
		    
		 MemberDto memberDto = memberService.getMember(email);
		 Member member = memberService.dtoToEntity(memberDto);
		 LocalDate date = LocalDate.now(); 
		 
		 CommentDto commentDto = commentService.getComment(comment_id);
		 commentDto.setContent(content);
		 commentDto.setDate(date); //날짜 갱신 추가
		 commentService.modify(commentDto);
		
		return Map.of("result", "success");
	}
	
	@DeleteMapping("/delete")
	public Map<String, String> deleteComment(
			@RequestParam(name="comment_id") int comment_id
			){
		commentService.delete(comment_id);
		
		return Map.of("result", "success");
	}
	
}
