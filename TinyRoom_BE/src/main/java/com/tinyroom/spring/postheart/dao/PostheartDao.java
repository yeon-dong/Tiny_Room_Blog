package com.tinyroom.spring.postheart.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.postheart.domain.PostHeart;


public interface PostheartDao extends JpaRepository<PostHeart, Integer>{
	int countByPost(Post post);
	// Member와 Post를 기준으로 PostHeart 가져오기
    Optional<PostHeart> findByMemberAndPost(Member member, Post post);
}
