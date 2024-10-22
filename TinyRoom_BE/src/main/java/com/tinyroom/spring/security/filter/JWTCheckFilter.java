package com.tinyroom.spring.security.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.security.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JWTCheckFilter extends OncePerRequestFilter {
	// 권한 필터에 안걸리게 하는 경로 설정
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		// 요청으로부터 경로(URI) 추출
		String path = request.getRequestURI();
		log.info("###############// check url :" + path);
		
		// 권한 필터에 안걸리게 하는 경로 설정(현재는 login 페이지가 /members/login 으로 되어있어 /members 로 시작하는 경로는 걸리지 않도록 함
		if(path.startsWith("/members/")) {
			return true;
		}
		if(path.startsWith("/posts/")) {
			return true;
		}
		
		
		// 위의 경로 이외에는 정상적으로 필터를 거친다
		return false;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			
			log.info("###############dododoFilter#####################");
			log.info("###############dododoFilter#####################");
			log.info("###############dododoFilter#####################");
			
			// request에서 cookie들을 가져와 배열에 담음
			Cookie[] cookies = request.getCookies();
	    	
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
	    	}
			// 프론트 쪽에서 Header에 AccessToken을 담아서 보낼텐데 지금은 Key를 "Authorization"으로 설정하여
			// 여기에 AccessToken을 담아서 보내낟고 가정하고 이렇게 작성함
			// (이 부분은 추후에 프론트 쪽과 맞춰봐야할 듯)
//			String authHeaderStr = request.getHeader("Authorization");
			
			
			try {
				// 일반적으로 'Authorization' 헤더에는 다음과 같은 형식의 값이 포함됨 
				// Authorization: Bearer <token> -> 여기에서 'Bearer ' 부분이 7자이므로
				// 이를 제외한 JWT 토큰 부분을 가져오는 코드
//				String accessToken = authHeaderStr.substring(7);
				
				// 토큰 유효성 검사 후 결과를 Map에 저장(유효성 검사 메서드에서 반환 타입이 Map)
				Map<String, Object> claims =  JWTUtil.validateToken(accessToken);
				
				log.info("##############jwt claims : " + claims);
				
				// claims에서 필요한 정보를 Key 값으로 추출
				String email = (String)claims.get("email");
				String pw = (String)claims.get("pw");
				List<String> roleNames = (List<String>)claims.get("roleNames");
				
				// MemberDto에 추출한 정보를 저장
				MemberDto memberDto = new MemberDto(email,pw,roleNames);
				
				log.info(memberDto);
				log.info(memberDto.getAuthorities());
				
				// 사용자 인증을 위한 Authentication 객체를 생성하는데 사용됨
				// memberDto.getAuthorities() -> 사용자가 가진 권한의 목록을 GrantedAuthority 객체로 반환 -> 사용자의 권한 검증에 사용
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberDto, pw,memberDto.getAuthorities());
				
				// 현재 인증된 사용자의 정보를 설정하는 코드
				// SecurityContextHolder -> Spring Security에서 현재 스레드의 보안 컨텍스트를 저장하는 클래스이고 애플리케이션의
				// 							모든 부분에서 보안 정보를 접근할 수 있게 해준다.
				// getContext(): 현재 스레드의 SecurityContext를 반환(인증 정보와 같은 보안 관련 정보가 포함됨)
				// setAuthentication(authenticationToken) : SecurityContext에 인증 정보를 설정한다.
				// 여기서 authenticationToken은 UsernamePasswordAuthenticationToken 객체로, 인증된 사용자에 대한 정보를 포함
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				
				// 현재 요청을 다음 필터로 전달
				filterChain.doFilter(request, response);
			} catch (Exception e) {
				
				log.info("JWT check error");
				
				
				// 예외 발생시 Gson에 에러 메세지를 저장한 후 Json 문자열로 변환하여 출력
				Gson gson = new Gson();
				
				String jsonStr = gson.toJson(Map.of("error","ERROR_ACCESS_TOKEN"));
				response.setContentType("application/json;charset=utf-8");
				
				PrintWriter printWriter = response.getWriter();
				printWriter.print(jsonStr);
				printWriter.close();
				
			}
			
			
			
	}
}
