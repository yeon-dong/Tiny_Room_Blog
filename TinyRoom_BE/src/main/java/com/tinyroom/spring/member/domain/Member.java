package com.tinyroom.spring.member.domain;

import java.util.List;
import java.util.ArrayList;

import com.tinyroom.spring.post.domain.Post;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "memberRoleList")	// memberRoleList는 제외하고 ToString 생성
public class Member {
	// member_id -> 멤버 식별자(PK)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int member_id;
	
	// email -> 아이디로 사용할 컬럼
	private String email;
	// pw -> 비밀번호에 해당
	private String pw;
	// name -> 회원 이름
	private String name;
	// nickname -> 회원 닉네임
	private String nickname;
	// phone_number -> 회원 전화번호
	private String phone_number;
	// profile_img	-> 프로필 이미지
	private String profile_img;
	// description -> 소개글
	private String description;
	// is_active -> 활성화 여부(삭제 여부) : 삭제했을 때 db에서 실제로 삭제되는 것이 아니라 상태값으로 관리
	private int is_active; //삭제 계정 판단 여부
	
	private String type;	// 역할 user
}
