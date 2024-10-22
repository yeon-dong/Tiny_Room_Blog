package com.tinyroom.spring.member.dto;

import lombok.Data;

@Data
public class MemberLoginRequestDto {
	private String email;	// 로그인 시 사용되는 회원 이메일
	private String pw;	// 로그인 시 사용되는 회원 비밀번호
	private String refreshToken;	// 새로 고침 토큰 (JWT 리프레시 용도)
}
