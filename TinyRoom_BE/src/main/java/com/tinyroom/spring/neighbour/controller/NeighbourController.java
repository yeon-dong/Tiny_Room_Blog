package com.tinyroom.spring.neighbour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinyroom.spring.member.controller.MemberController;
import com.tinyroom.spring.member.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*")
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
public class NeighbourController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/user/{userId}/neighbour")
	public boolean applyNeighbour(
			@PathVariable("userId") int id
			) {
		
		
		return false;
	}
}
