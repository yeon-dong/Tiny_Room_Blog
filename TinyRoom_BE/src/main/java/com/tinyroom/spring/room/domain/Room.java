package com.tinyroom.spring.room.domain;

import com.tinyroom.spring.blog.domain.Blog;

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
public class Room {
	// room_id -> 마이룸 식별자(PK)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_id;
	
	// blog_id -> Blog와 1:1 관계 : 블로그 식별자
	@OneToOne
	@JoinColumn(name="blog_id")
	private Blog blog;
	
	private int room_theme;	// 테마
	private int furniture1;	// 가구 시리얼 넘버(카테고리 1)
	private int furniture2;	// 가구 시리얼 넘버(카테고리 2)
	private int furniture3;	// 가구 시리얼 넘버(카테고리 3)
	private int furniture4;	// 가구 시리얼 넘버(카테고리 4)
	
	private int character;
	
}
