package com.tinyroom.spring.security.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.tinyroom.spring.security.CustomUserDetailService;
import com.tinyroom.spring.security.filter.JWTCheckFilter;
import com.tinyroom.spring.security.handler.CustomAccessDeniedHandler;
import com.tinyroom.spring.security.handler.LoginFailHandler;
import com.tinyroom.spring.security.handler.LoginSuccessHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@RequiredArgsConstructor	// final 필드를 가진 생성자를 자동 생성
@EnableMethodSecurity	// 메서드 수준의 보안 활성화
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		log.info("################### security config ######################");
		
		// CORS 설정
		http.cors(httpSecurityCorsConfigurer -> {
			httpSecurityCorsConfigurer.configurationSource(CorsConfigurationSource());
		});
		
		// CSRF 보호 비활성화
		http.csrf(config -> config.disable());
		
		// 세션 관리 설정: Stateless로 설정하여 세션 사용 안 함
		http.sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //세션비활성화

		// 로그인 설정
		http.formLogin(
				config -> {
					config.loginPage("/members/login");		// 로그인 페이지 경로 설정 -> /members로 시작하는 경로는 필터링 걸리지 않음(누구나 접근 가능)
					config.successHandler(new LoginSuccessHandler()); // 로그인 성공 시 처리 -> token 발행, 200ok정보출력
					config.failureHandler(new LoginFailHandler()); // 로그인 실패 시 처리 -> 200ok 회원자료무
				}
				);
		
		// JWT 토큰 검증 필터 추가
		http.addFilterBefore(new JWTCheckFilter(), UsernamePasswordAuthenticationFilter.class); // 토큰 인증 여부확인
		
		// 권한 확인 후 권한이 없는 기능에 접근하려고 할 때 접근 거부 처리 설정
		http.exceptionHandling(config -> {
			config.accessDeniedHandler(new CustomAccessDeniedHandler());
		});
		
		// 설정된 HttpSecurity 객체를 바탕으로 SecurityFilterChain 생성
		return http.build();
	}
	
	// 비밀번호 암호화에 사용할 PasswordEncoder Bean 정의
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();	// BCrypt 알고리즘을 사용한 암호화
	}

	 // CORS 설정을 위한 CorsConfigurationSource Bean 정의
	@Bean
	public org.springframework.web.cors.CorsConfigurationSource CorsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		
		// 허용할 출처 설정
        configuration.setAllowedOrigins(Arrays.asList("*"));	// 모든 출처 허용
        // 허용할 HTTP 메서드 설정
        configuration.setAllowedMethods(Arrays.asList("HEAD","GET","POST","PUT","DELETE","OPTIONS"));
        // 허용할 HTTP 헤더 설정
        configuration.setAllowedHeaders(Arrays.asList("Authorization","Cache-Control","Content-Type"));
        configuration.setAllowCredentials(true);	// 쿠키와 같은 자격 증명 사용 허용

        // CORS 설정을 URL에 매핑
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);	// 모든 경로에 대해 CORS 설정 적용

        // CORS 설정 반환
        return source;
	}
}
