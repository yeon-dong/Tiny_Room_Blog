package com.tinyroom.spring.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tinyroom.spring.blog.dao.BlogDao;
import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.post.dto.PostDto;

import jakarta.persistence.EntityManager;

import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.domain.QPost;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private final JPAQueryFactory queryFactory;
	
	public BlogServiceImpl(EntityManager em){
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	public BlogDto getBlog(Member member) {
		
	      Blog blog = blogDao.findByMember(member).orElse(null);// orElse(null): 검색결과 없으면 널 반환
	      
	      if (blog == null) {
	         return null;
	      }
	      return blogEntityToDto(blog);
	}
	
	@Override
	public List<Post> findPostByUserId(int id, int category, int page) {
		return queryFactory.selectFrom(QPost.post)
				.where(QPost.post.member.member_id.eq(id))
				.offset(page * 4)	// size : 4로 고정
				.limit(4)
				.fetch();
	}
	
	
	@Override
	public int getPostCount(int id, int category) {
		BooleanBuilder builder = new BooleanBuilder();
		
		builder.and(QPost.post.member.member_id.eq(id));
		
		if(category != 0) builder.and(QPost.post.category.category_id.eq(category));
		
		builder.and(QPost.post.is_active.eq(1));
		
		return queryFactory.selectFrom(QPost.post)
				.where(builder)
				.fetch().size();
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
