package com.tinyroom.spring.postheart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.postheart.domain.PostHeart;


public interface PostheartDao extends JpaRepository<PostHeart, Integer>{
	int countByPost(Post post);
}
