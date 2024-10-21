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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDto extends User{
	private int member_id; // 회원 ID
    private String email; // 회원 이메일
    private String pw; // 회원 비밀번호
    private String name; // 회원 이름
    private String nickname; // 회원 닉네임
    private String profile_img; // 회원 프로필 이미지 URL
    private String description; // 회원에 대한 설명
    private int is_active; // 회원 활성화 상태 (0: 비활성, 1: 활성)
    private List<String> roleNames = new ArrayList<>(); // 회원의 역할 이름 리스트
	
    // 생성자: 이메일, 비밀번호, 역할 이름 목록을 인자로 받아 MemberDto 객체 생성
	public MemberDto(String email, String pw, List<String> roleNames) {
		// 상위 클래스(User)의 생성자를 호출하여 권한 설정
		super(email, pw, roleNames.stream().map(str -> new SimpleGrantedAuthority("ROLE_" + str)).collect(Collectors.toList()));
		
		this.email = email;	// 이메일 초기화
		this.pw = pw;	// 비밀번호 초기화
		this.roleNames = roleNames;	// 역할 이름 리스트 초기화
	}
	
	// 클레임을 반환하는 메서드
	public Map<String, Object> getClaims(){
		Map<String, Object> dataMap = new HashMap<>();
		// 이메일, 비밀번호, 역할 이름을 클레임에 추가
		dataMap.put("email", email);
		dataMap.put("pw", pw);
		dataMap.put("roleNames", roleNames);
		
		return dataMap;	// 클레임 데이터 반환
	}
}
