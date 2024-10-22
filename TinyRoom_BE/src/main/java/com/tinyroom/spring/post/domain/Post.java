package com.tinyroom.spring.post.domain;


import java.util.Date;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.member.domain.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Post {
	// post_id -> 포스트 식별자 (PK)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int post_id;
	
	// member_id -> Member와 1:N 관계 (N 쪽)
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	// category_id -> 카테고리와 1:N 관계 (N 쪽)
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	private Date date;	// date -> 포스트 작성일자
	private String title;	// 포스트 제목
	private String content;	// 포스트 내용
	private String post_img;	// 포스트 첨부 이미지
	private int is_active; // 활성화 여부(삭제 여부) : 삭제했을 때 db에서 실제로 삭제되는 것이 아니라 상태값으로 관리
}
