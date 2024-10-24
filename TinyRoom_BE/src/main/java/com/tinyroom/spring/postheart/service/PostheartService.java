package com.tinyroom.spring.postheart.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PostDto;
import com.tinyroom.spring.postheart.domain.PostHeart;
import com.tinyroom.spring.postheart.dto.PostheartDto;

public interface PostheartService {
	int getCount(Post post);
	int addHeart(PostHeart postHeart);
	PostheartDto getHeart(Member member, Post post);
	void deleteHeart(int post_heart_id);
	
	default PostheartDto entityPostheartDto(PostHeart postheart) {
		PostheartDto postheartDto = PostheartDto.builder()
				.post_heart_id(postheart.getPost_heart_id())
				.member(postheart.getMember())
				.post(postheart.getPost())
				.build();
		return postheartDto;
	}
	
	default PostHeart dtoToEntity(PostheartDto postheartDto) {
		PostHeart postheart = PostHeart.builder()
				.post_heart_id(postheartDto.getPost_heart_id())
				.member(postheartDto.getMember())
				.post(postheartDto.getPost())
				.build();
		return postheart;
	}
}
