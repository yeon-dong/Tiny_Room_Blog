package com.tinyroom.spring.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tinyroom.spring.blog.domain.Blog;

public interface BlogDao extends JpaRepository<Blog, Integer> {

}
