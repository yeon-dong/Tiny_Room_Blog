package com.tinyroom.spring.member.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class MemberDto{
	private int member_id; // 회원 ID
    private String email; // 회원 이메일
    private String pw; // 회원 비밀번호
    private String name; // 회원 이름
    private String nickname; // 회원 닉네임
    private String phone_number; // 회원 전화번호
    private String profile_img; // 회원 프로필 이미지 URL
    private String description; // 회원에 대한 설명
    private int is_active; // 회원 활성화 상태 (0: 비활성, 1: 활성)
    private String type;	// user
    
//    public MemberDto(String email, String pw, String name, String nickname, String phone_number, String type) {
//    	this.email = email;
//    	this.pw = pw;
//    	this.name = name;
//    	this.nickname = nickname;
//    	this.phone_number = phone_number;
//    	this.type = type;
//    }
}
