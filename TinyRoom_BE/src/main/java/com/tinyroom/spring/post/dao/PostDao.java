package com.tinyroom.spring.post.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tinyroom.spring.post.dao.search.PostSearch;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;

public interface PostDao extends JpaRepository<Post, Integer>, PostSearch{

	Page<Post> search1(PageRequestDto pageRequestDto);

}
