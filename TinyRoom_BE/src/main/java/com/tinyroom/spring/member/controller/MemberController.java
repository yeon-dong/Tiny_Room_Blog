package com.tinyroom.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinyroom.spring.member.dto.MemberLoginRequestDto;
import com.tinyroom.spring.member.service.MemberService;
import com.tinyroom.spring.security.util.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
@RequestMapping("/member")	// "/member" 경로에 대한 요청을 처리하는 클래스(처음에 /members 로 했는데 
public class MemberController {
    
	// ROLE_ADMIN 권한을 가진 사용자만 접근할 수 있는 메서드
    @PreAuthorize("hasAnyRole('ROLE_USER')")	// 메서드 접근 권한 설정
    @GetMapping("/test")	// GET 요청을 처리하고 "/member/test" 경로에 매핑
    public String test(HttpServletRequest request) {
    	// 테스트 응답을 반환
    	return "test";	// 클라이언트에 "test" 문자열 반환
    }
}
