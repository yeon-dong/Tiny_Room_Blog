package com.tinyroom.spring.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.Tuple;
import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.blog.dto.PostPageDto;
import com.tinyroom.spring.blog.service.BlogService;
import com.tinyroom.spring.member.controller.MemberController;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.member.service.MemberService;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.service.PostService;
import com.tinyroom.spring.room.dto.RoomDto;
import com.tinyroom.spring.room.service.RoomService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*")
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
public class BlogController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private PostService postService;
	
	// 좌측 프로필 부분에 들어갈 데이터
	@GetMapping("/blog/{userId}")
	public Map getMemberInfo(@PathVariable("userId") int id) {
		log.info("############################### mypage ##############################");
		
		MemberDto memberDto = memberService.getProfile(id);
		BlogDto blogDto = blogService.getBlog(memberService.dtoToEntity(memberDto));
		RoomDto roomDto = roomService.getRoom(blogService.blogDtoToEntity(blogDto));
		
		log.info("####################### memberDto : " + memberDto);
		log.info("####################### BlogDto : " + blogDto);
		log.info("####################### memberDto : " + memberDto);
		
		Map result = new HashMap();
		Map member = new HashMap();
		Map blog = new HashMap();
		Map room = new HashMap();
		
		member.put("userId", memberDto.getMember_id());
		member.put("nickname", memberDto.getNickname());
		member.put("profileImg", memberDto.getProfile_img());
		member.put("description", memberDto.getDescription());
		
		blog.put("blogId", blogDto.getBlog_id());
		blog.put("title", blogDto.getBlog_title());
		blog.put("blogTheme", blogDto.getBlog_theme());
		
		room.put("roomId", roomDto.getRoom_id());
		room.put("roomTheme", roomDto.getRoom_theme());
		room.put("furniture1", roomDto.getFurniture1());
		room.put("furniture2", roomDto.getFurniture2());
		room.put("furniture3", roomDto.getFurniture3());
		room.put("furniture4", roomDto.getFurniture4());
		room.put("character", roomDto.getCharacter());
		
		result.put("user", member);
		result.put("blog", blog);
		result.put("room", room);
		
		return result;
	}
	
	@GetMapping("/user/{userId}")
	public Map getUserPostList(
			@PathVariable("userId") int id,
			@RequestParam("category") int category,
			@RequestParam(required = false, defaultValue = "0", value = "page") int page
			) {
		log.info("############################### mypage ##############################");
		Map result = new HashMap();
		
		List<PostPageDto> li = blogService.getPostList(id, category, page);
		int totalCount = blogService.countPost(id, category);
		
		
		
		result.put("totalCount", totalCount);
		result.put("data", li);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
