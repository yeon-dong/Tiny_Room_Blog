package com.tinyroom.spring.security.util;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JWTUtil {
	// JWT Token 생성을 위한 보안키
	private static String key = "asdfdfghjhgukjhljkdyhywsrgegsrthtyjguil;yujrthyjfhgkeargaegthaegahukgjhlsfghdghg";
	
	// 토큰을 생성하여 반환
    public static String generateToken(Map<String, Object> valueMap, int min) {

    	// 비밀키를 저장할 변수 선언
        SecretKey key = null;

        try{
        	// HMAC SHA 키 생성 : 주어진 문자열을 바이트 배열로 변환하여 HMAC SHA 키로 변환
        	key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));

        }catch(Exception e){
        	// 키 생성 중 오류가 발생하면 예외를 던짐
            throw new RuntimeException(e.getMessage());
        }

        // JWT 문자열 생성
        String jwtStr = Jwts.builder()
                .setHeader(createHeader())	// JWT 헤더 설정
                .setClaims(valueMap)	// JWT에 포함할 사용자 정의 클레임 설정
                .setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))	// JWT 발급 시간 설정
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(min).toInstant()))	// JWT 만료 시간 설정
                .signWith(key)	// 비밀키로 서명
                .compact();	// 최종 JWT 문자열 생성

        return jwtStr;
    }

    // 헤더에 담기 위한 정보를 Map에 담아서 반환 -> 토큰 생성시 사용
    public static Map<String, Object> createHeader() {
		Map<String, Object> map = new HashMap<>();
		map.put("typ", "JWT");
		map.put("alg", "HS256");
		map.put("regDate", System.currentTimeMillis());
		return map;
	}
    
    // 토큰의 유효성 검사
    public static Map<String, Object> validateToken(String token) {
    	
    	// Claim 정보를 담을 Map 선언
        Map<String, Object> claim = null;

        try{
        	// HMAC SHA 키 생성 : 주어진 문자열을 바이트 배열로 변환하여 HMAC SHA 키로 변환
            SecretKey key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));

            // JWT 파싱 및 검증
            claim = Jwts.parserBuilder()
                    .setSigningKey(key)		// 서명에 사용할 비밀키 설정
                    .build()
                    .parseClaimsJws(token) // JWT 파싱 및 검증, 실패 시 에러
                    .getBody();	// 파싱된 클레임 반환

        }catch(MalformedJwtException malformedJwtException){
            throw new CustomJWTException("MalFormed"); // 잘못된 형식의 JWT가 전달된 경우
        }catch(ExpiredJwtException expiredJwtException){
            throw new CustomJWTException("Expired"); // 만료된 JWT가 전달된 경우
        }catch(InvalidClaimException invalidClaimException){
            throw new CustomJWTException("Invalid"); // JWT의 클레임이 유효하지 않은 경우
        }catch(JwtException jwtException){
            throw new CustomJWTException("JWTError"); // 기타 JWT 관련 오류 발생 시
        }catch(Exception e){
            throw new CustomJWTException("Error");// 그 외의 예외 발생 시
        }
        return claim;
    } 
}
