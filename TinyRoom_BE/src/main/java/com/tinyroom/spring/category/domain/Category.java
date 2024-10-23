package com.tinyroom.spring.category.domain;

import java.util.List;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.domain.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
	// category_id -> 카테고리 식별자(PK)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int category_id;
	
	// category_name -> 카테고리 이름(가전제품, 전자제품 ...)
	private String category_name;
}
