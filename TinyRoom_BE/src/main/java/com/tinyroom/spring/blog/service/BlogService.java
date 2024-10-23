package com.tinyroom.spring.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;

public interface BlogService {

	public BlogDto getBlog(Member member);
	
	BlogDto blogEntityToDto(Blog blog);
	
	Blog blogDtoToEntity(BlogDto blogDto);
	
}
