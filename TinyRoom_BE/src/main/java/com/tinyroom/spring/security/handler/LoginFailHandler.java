package com.tinyroom.spring.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.security.sasl.AuthenticationException;

import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginFailHandler implements AuthenticationFailureHandler {

	// 인증 실패시 호출되는 메서드
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException exception) throws IOException, ServletException {
		log.info("-------------------------");
		log.info("-------login fail--------");
		log.info("-------------------------" + exception);
		
		// Json 변환을 위한 Gson 객체 생성
		Gson gson = new Gson();
		
		// 에러 메세지을 Json 문자열로 변환
		String jsonStr = gson.toJson(Map.of("error","ERROR_LOGIN"));
		// 응답 타입을 Json으로 설정
		response.setContentType("application/json");
		
		// 응답에 Json 문자열 출력
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonStr);
		printWriter.close();		
	}
}
