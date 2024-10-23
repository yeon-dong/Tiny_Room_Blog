package com.tinyroom.spring.blog.domain;

import com.tinyroom.spring.member.domain.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Blog {
	// blog_id -> 블로그 식별자(PK)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blog_id;
	
	// member_id -> Member Entity와 연결되는 FK (1:1 관계)
	@OneToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	// blog_title -> 블로그 제목(이름)
	private String blog_title;
	// blog_theme -> 블로그 테마 번호
	private int blog_theme;
}
