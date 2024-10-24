package com.tinyroom.spring.neighbour.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.member.service.MemberService;
import com.tinyroom.spring.neighbour.domain.Neighbour;
import com.tinyroom.spring.neighbour.dto.NeighbourDto;
import com.tinyroom.spring.neighbour.service.NeighbourService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
@RequestMapping("/neighbour")
public class NeighbourController {
	@Autowired
	NeighbourService neighbourService;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/sendApprove")
	public Map<String, String> sendApprove(
			@RequestParam(name="to_member_email")String to_member_email
			){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName();
	    MemberDto from_memberDto = memberService.getMember(email);
	    Member from_member = memberService.dtoToEntity(from_memberDto);
	    
	    MemberDto to_memberDto = memberService.getMember(email);
	    Member to_member = memberService.dtoToEntity(to_memberDto);
	    
	    NeighbourDto neighbourDto = NeighbourDto.builder()
	    		.from_member(from_member)
	    		.to_member(to_member)
	    		.status(0)
	    		.build();
	    
	    neighbourService.sendApprove(neighbourDto);
		return Map.of("result", "success");
	}
	
	@GetMapping("/Approve")
	public Map<String, String> approve(
			@RequestParam(name="neighbour_id")int neighbour_id
			){
		Neighbour neighbour = neighbourService.getNeighbour(neighbour_id);
		NeighbourDto neighbourDto = neighbourService.entityNeighbourDto(neighbour);
		neighbourDto.setStatus(1);
		neighbourService.modifyStatus(neighbourDto);
		
		return Map.of("result", "success");
	}
}
