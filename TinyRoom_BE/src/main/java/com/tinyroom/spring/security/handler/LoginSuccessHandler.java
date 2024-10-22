package com.tinyroom.spring.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.security.util.JWTUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	// 인증 성공시 호출되는 메서드
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("-------------------------");
		log.info("-----authentication------");
		log.info("-------------------------");
		
		// 인증된 사용자 정보 가져오기
		// authentication.getPrincipal() 메서드는 인증된 사용자에 대한 주체 정보를 반환하며, 이 정보는 사용자 인증 및 권한 부여에 활용
		MemberDto memberDto = (MemberDto) authentication.getPrincipal();
		
		// 사용자 클레임 정보 가져오기(MemberDto에 정의됨)
		Map<String, Object> claims =  memberDto.getClaims();
		
		// accessToken, refreshToken 생성
		String accessToken = JWTUtil.generateToken(claims, 10);
		String refreshToken = JWTUtil.generateToken(claims, 60*24);
		
		// AccessToken 쿠키 설정
		Cookie accessTokenCookie = new Cookie("AccessToken", accessToken);
		accessTokenCookie.setHttpOnly(true);	// JavaScript에서 접근 불가 -> 자동으로 Cookie Header에 추가됨
		accessTokenCookie.setSecure(false);	// Https 아니어도 전송 가능
		accessTokenCookie.setPath("/");	// 쿠키의 경로 설정
//		accessTokenCookie.setMaxAge(60 * 10);	// 유효 기간(10분)
		accessTokenCookie.setMaxAge(20);
		accessTokenCookie.setAttribute("SameSite", "Lax");	// SameSite 설정
		
		// AccessToken 쿠키 설정
		Cookie refreshTokenCookie = new Cookie("RccessToken", refreshToken);
		accessTokenCookie.setHttpOnly(true);	// JavaScript에서 접근 불가 -> 자동으로 Cookie Header에 추가됨
		accessTokenCookie.setSecure(false);	// Https 아니어도 전송 가능
		accessTokenCookie.setPath("/");	// 쿠키의 경로 설정
		accessTokenCookie.setMaxAge(60 * 60 * 24);	// 유효 기간(1일)
		accessTokenCookie.setAttribute("SameSite", "Lax");	// SameSite 설정
		
		
		// 쿠키를 응답에 추가
		response.addCookie(accessTokenCookie);
		response.addCookie(refreshTokenCookie);
		
		// 생성된 토큰을 클레임에 추가
//		claims.put("accessToken",accessToken);
//		claims.put("refreshToken", refreshToken);
		
		// Json 변환을 위한 Gson 객체 생성
		Gson gson = new Gson();
		
		// 클레임을 Json 문자열로 변환
		String jsonStr = gson.toJson(claims);
		// 응답 타입을 Json으로 설정
		response.setContentType("application/json;charset=utf-8");
		
		// 응답에 Json 문자열 출력
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonStr);
		printWriter.close();					
	}

}
