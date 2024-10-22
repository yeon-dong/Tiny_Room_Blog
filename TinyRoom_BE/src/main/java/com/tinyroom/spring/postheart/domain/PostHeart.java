package com.tinyroom.spring.postheart.domain;

import java.util.List;

import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.domain.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostHeart {
	// post_heart_id -> 포스트 좋아요 식별자
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int post_heart_id;
	
	// member_id -> Member와 1:N 관계 (N 쪽) : 작성자
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	// post_id -> Post와 1:N 관계 (N 쪽) : 좋아요한 포스트 
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
}
