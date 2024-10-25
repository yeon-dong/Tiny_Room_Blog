package com.tinyroom.spring.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration {
	private final TokenProvider provider;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.httpBasic(HttpBasicConfigurer::disable);
//        .csrf(CsrfConfigurer::disable)  //post, put, delete 요청 안먹음
		http.csrf().disable();
		http.cors().configurationSource(corsConfigurationSource());
		http.authorizeHttpRequests((authz)-> authz
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()//forward 요청은 모두 허용
				.requestMatchers("/member/**","/comments/writeComment", "/comments/updateComment", "/comments/delete", "/member/info", "/member/modify", "/neighbour/sendApprove", "/neighbour/approve", "/neighbour/refuse", "/neighbour/sendList", "/neighbour/neighbourList", "/posts/postUpdate", "/posts/delete", "/posts/writePost","/hearts/view","/hearts/add", "/hearts/delete").hasRole("USER")  //url이 /auth/로 시작하면 인증을 요구 ROLE_USER
				.requestMatchers("/", "/register", "/error", "/login", "/read-img/**", "/blog/**", "/user/**", " /comments/commentList", "/comments/view", "/register", "/login", " /image/**", "/posts/recommend", "/posts/postDetail", "/posts/main", "/posts/calendar").permitAll()
				.anyRequest().permitAll()
				);
		//토큰 처리하는 필터를 현재 필터 앞에 붙임
		http.addFilterBefore(new JwtAuthenticationFilter(provider), UsernamePasswordAuthenticationFilter.class);
		//세션 정책을 stateless로 설정. 상태유지 안함.
		http.sessionManagement(configurer->configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://localhost:5173", "127.0.0.1:5173"));
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
