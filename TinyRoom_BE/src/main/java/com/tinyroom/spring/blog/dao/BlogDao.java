package com.tinyroom.spring.blog.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.member.domain.Member;

@Repository
public interface BlogDao extends JpaRepository<Blog, Integer> {
	
    Optional<Blog> findByMember(Member member);
}
