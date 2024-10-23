package com.tinyroom.spring.postheart.dto;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.domain.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class PostheartDto {
	private int post_heart_id;
	private Member member;

	private Post post;
	
	private int is_active;
}
