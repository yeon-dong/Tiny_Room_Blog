package com.tinyroom.spring.post.dao.search;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.jpa.JPQLQuery;

import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PostSearchImpl extends QuerydslRepositorySupport implements PostSearch{

	public PostSearchImpl() {
		super(Post.class);
	}

	@Override
	public Page<Post> search1(PageRequestDto pageRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Page<Post> search1(PageRequestDto pageRequestDto) {
//		log.info("search1#######################");
//		
//		QPost post = Qpost.todoEntity;
//		JPQLQuery<TodoEntity> query = from(todoEntity);
//		
////		query.where(todoEntity.title.contains("test"));
//		
//		Pageable pageable = PageRequest.of(pageRequestDto.getPage()-1, pageRequestDto.getSize(),Sort.by("tno").descending());
//		query.offset(pageable.getOffset());
//		query.limit(pageable.getPageSize());
//		query.orderBy(todoEntity.tno.desc());
//		List<TodoEntity> list =  query.fetch();
//		long total =  query.fetchCount();
//		
//		return new PageImpl<>(list,pageable,total);
//
//	}
//

	
}
