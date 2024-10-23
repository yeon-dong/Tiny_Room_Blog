package com.tinyroom.spring.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.blog.dao.BlogDao;
import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BlogDao blogDao;
	
	public BlogDto getBlog(Member member) {
		
	      Blog blog = blogDao.findByMember(member).orElse(null);// orElse(null): 검색결과 없으면 널 반환
	      
	      if (blog == null) {
	         return null;
	      }
	      return blogEntityToDto(blog);
	}
	
	@Override
	public BlogDto blogEntityToDto(Blog blog) {
		BlogDto blogDto = BlogDto.builder()
				.blog_id(blog.getBlog_id())
				.member_id(blog.getMember().getMember_id())
				.blog_title(blog.getBlog_title())
				.blog_theme(blog.getBlog_theme())
				.build();
		
		return blogDto;
	}
	
	@Override
	public Blog blogDtoToEntity(BlogDto blogDto) {
		Blog blog = Blog.builder()
				.blog_id(blogDto.getBlog_id())
				.member(memberDao.findById(blogDto.getMember_id()).orElse(null))
				.blog_title(blogDto.getBlog_title())
				.blog_theme(blogDto.getBlog_theme())
				.build();
		
		return blog;
	}

}
