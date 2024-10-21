package com.tinyroom.spring.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	// 접근 거부 시 호출되는 메서드
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		// 현재 인증된 사용자 정보 가져오기
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// 사용자가 인증된 경우
        if (auth != null) {
            // 사용자의 Role을 가져오기
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            for (GrantedAuthority authority : authorities) {
            	// 각 Role을 로그에 기록
                log.info("Role: " + authority.getAuthority());
            }
        }
		
     // Json 변환을 위한 Gson 객체 생성
		Gson gson = new Gson();
		
		// 에러 메세지를 Json 문자열로 변환
		String jsonStr = gson.toJson(Map.of("error","ERROR_ACCESSDENIED"));
		// 응답 타입을 Json으로 설정
		response.setContentType("application/json");
		// HTTP 응답 상태를 403 Forbidden으로 설정
		response.setStatus(HttpStatus.FORBIDDEN.value());

		// 응답에 Json 문자열 출력
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonStr);
		printWriter.close();
	}

}
