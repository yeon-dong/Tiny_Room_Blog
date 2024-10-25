package com.tinyroom.spring.neighbour.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.blog.service.BlogService;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.member.service.MemberService;
import com.tinyroom.spring.neighbour.domain.Neighbour;
import com.tinyroom.spring.neighbour.dto.NeighbourDto;
import com.tinyroom.spring.neighbour.dto.NeighbourPageDto;
import com.tinyroom.spring.neighbour.dto.NeighbourPageDto2;
import com.tinyroom.spring.neighbour.dto.RequestSendNeighbourDto;
import com.tinyroom.spring.neighbour.dto.ResponseNeighbourDto;
import com.tinyroom.spring.neighbour.service.NeighbourService;
import com.tinyroom.spring.neighbour.dto.ResponseSendNeighbourDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
@RequestMapping("/neighbour")
public class NeighbourController {
	@Autowired
	NeighbourService neighbourService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BlogService blogService;
	
	@GetMapping("/sendApprove")
	public Map<String, String> sendApprove(
			@RequestBody RequestSendNeighbourDto requestSendNeighbourDto
			){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName();
	    
	    MemberDto from_memberDto = memberService.getMember(email);
	    Member from_member = memberService.dtoToEntity(from_memberDto);
	    
	    MemberDto to_memberDto = memberService.getMemberById(requestSendNeighbourDto.getTo_member_id());
	    Member to_member = memberService.dtoToEntity(to_memberDto);
	    
	    NeighbourDto neighbourDto = NeighbourDto.builder()
	    		.from_member(from_member)
	    		.to_member(to_member)
	    		.message(requestSendNeighbourDto.getMessage())
	    		.status(0)
	    		.build();
	    
	    neighbourService.sendApprove(neighbourDto);
		return Map.of("result", "success");
	}
	
	@GetMapping("/approve")
	public Map<String, String> approve(
			@RequestParam(name="neighbour_id")int neighbour_id
			){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName();
	    MemberDto memberDto = memberService.getMember(email);
	    Member member = memberService.dtoToEntity(memberDto);
	    
	    //내가 to 상대방이 from 인경우,,,,,
		Neighbour neighbour = neighbourService.getNeighbour(neighbour_id);
		NeighbourDto neighbourDto = neighbourService.entityNeighbourDto(neighbour);
		neighbourDto.setStatus(1);
		neighbourService.modifyStatus(neighbourDto);
		
		Member neighbour_m = neighbour.getFromMember();
		
		Neighbour fromNeighbourTo = Neighbour.builder()
				.fromMember(member)
				.toMember(neighbour_m)
				.status(1)
				.message(neighbour.getMessage())
				.build();
		
		neighbourService.approveNeighbour(fromNeighbourTo);
		return Map.of("result", "success");
	}
	
	@DeleteMapping("/refuse")
	public Map<String, String> refuse(
			@RequestParam(name="neighbour_id")int neighbour_id
			){
		neighbourService.deleteNeighbour(neighbour_id);
		
		return Map.of("result", "success");
	}
	
	//이웃 신청 목록 조회
	//to = me
	@GetMapping("/sendList")
	public Map sendNeighbourList(
			@RequestParam(required = false, defaultValue = "0", value = "page") int page
			){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName();
	    MemberDto memberDto = memberService.getMember(email);
	    Member member = memberService.dtoToEntity(memberDto);
	    
	    Map result = new HashMap();
	    
	    List<NeighbourPageDto> neighbourList =  neighbourService.getSendNeighbourList(member, page);
	    int totalCount = neighbourService.countSendNeighbour(member);
	   
	    result.put("totalCount", totalCount);
		result.put("data", neighbourList);
		return result;
	}
	
	@GetMapping("/neighbourList")
	public Map NeighbourList(
			@RequestParam(required = false, defaultValue = "0", value = "page") int page
			){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName();
	    MemberDto memberDto = memberService.getMember(email);
	    Member member = memberService.dtoToEntity(memberDto);
	    
	    Map result = new HashMap();
	    
	    List <NeighbourPageDto2> neighbourList = neighbourService.getNeighbourList2(member, page);
	    int totalCount = neighbourService.countNeighbour(member);
	    
//        return neighbourResponseList ;
	    result.put("totalCount", totalCount);
		result.put("data", neighbourList);
		
		return result;
	}
}
