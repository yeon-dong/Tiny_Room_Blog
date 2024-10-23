package com.tinyroom.spring.postheart.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinyroom.spring.post.domain.Post;

public interface PostheartService {
	int getCount(Post post);
}
