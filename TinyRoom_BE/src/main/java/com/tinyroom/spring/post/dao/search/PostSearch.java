package com.tinyroom.spring.post.dao.search;

import org.springframework.data.domain.Page;

import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;

public interface PostSearch {
	Page<Post> search1(PageRequestDto pageRequestDto);
}
