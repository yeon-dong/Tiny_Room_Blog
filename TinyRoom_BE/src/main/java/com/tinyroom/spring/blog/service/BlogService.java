package com.tinyroom.spring.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.querydsl.core.Tuple;
import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PostDto;

public interface BlogService {

	public BlogDto getBlog(Member member);
	
	public List<Tuple> findPostByUserId(int id, int category, int page);
	
	public int getPostCount(int id, int category);
	
	BlogDto blogEntityToDto(Blog blog);
	
	Blog blogDtoToEntity(BlogDto blogDto);
	
}
