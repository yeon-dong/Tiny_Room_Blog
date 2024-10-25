package com.tinyroom.spring.blog.service;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tinyroom.spring.blog.dao.BlogDao;
import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.blog.dto.PostPageDto;
import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.post.dto.PostDto;

import jakarta.persistence.EntityManager;

import com.tinyroom.spring.post.dao.PostDao;
import com.tinyroom.spring.post.domain.Post;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private PostDao postDao;
	
	public BlogDto getBlog(Member member) {
		
      Blog blog = blogDao.findByMember(member).orElse(null);// orElse(null): 검색결과 없으면 널 반환
      
      if (blog == null) {
         return null;
      }
      return blogEntityToDto(blog);
	}
	
	@Override
	public List<PostPageDto> getPostList(int id, int category, int page) {
		
		Pageable pageable = PageRequest.of(page, 4, Sort.by(Sort.Direction.DESC, "w_date"));
		org.springframework.data.domain.Page<PostPageDto> postPage = postDao.findByConditions(1, id, category, pageable);
		
		return postPage.getContent();
	}
	
	@Override
	public int countPost(int id, int category) {
		
		return postDao.countByConditions(1, id, category);
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