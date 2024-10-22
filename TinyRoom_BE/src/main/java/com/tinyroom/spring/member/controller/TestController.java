package com.tinyroom.spring.member.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class TestController {
	// ROLE_ADMIN 권한을 가진 사용자만 접근할 수 있는 메서드
    @PreAuthorize("hasAnyRole('ROLE_USER')")	// 메서드 접근 권한 설정
    @GetMapping("/test")	// GET 요청을 처리하고 "/member/test" 경로에 매핑
    public String test(HttpServletRequest request) {
    	
    	// request에서 cookie들을 가져와 배열에 담음
    	Cookie[] cookies = request.getCookies();
    	// 출력 결과를 담을 변수
    	String result = null;
    	
    	// accessToken, refreshToken을 담을 변수
    	String accessToken = null;
		String refreshToken = null;
    	
		// cookies 배열이 비어있지 않다면 cookies 배열 탐색해서 AccessToken, RefreshToken에 해당하는 값 변수에 대입 
    	if(cookies != null) {    		
    		for(Cookie cookie : cookies) {
    			if("AccessToken".equals(cookie.getName())) {
    				accessToken = cookie.getValue();
    			} else if("RefreshToken".equals(cookie.getName())) {
    				refreshToken = cookie.getValue();
    			}
    		}
    		// 출력 결과 생성
    		result = "AccessToken : " + accessToken + ", RefreshToken : " + refreshToken;
    	}
    	
		return result;
    }
}
