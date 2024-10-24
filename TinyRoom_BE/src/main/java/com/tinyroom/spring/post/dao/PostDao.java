package com.tinyroom.spring.post.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinyroom.spring.post.dao.search.PostSearch;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;
import org.springframework.data.domain.Pageable;
public interface PostDao extends JpaRepository<Post, Integer>, PostSearch{

	Page<Post> search1(PageRequestDto pageRequestDto);
	
	  @Query("SELECT p FROM Post p LEFT JOIN p.hearts h GROUP BY p ORDER BY COUNT(h) DESC")
	    List<Post> findTopByOrderByHeartCountDesc(Pageable pageable);

	  @Query("SELECT p FROM Post p " +
	           "WHERE p.is_active = :isActive " +
	           "AND p.member.member_id = :memberId " +
	           "AND p.category.category_id = :categoryId " +
	           "ORDER BY p.w_date DESC")
	  Page<Post> findByConditions(@Param("isActive") int isActive,
			  					@Param("memberId") int membereId,
			  					@Param("categoryId") int categoryId,
			  					Pageable pageable);

	  @Query("SELECT COUNT(*) FROM Post p " +
	           "WHERE p.is_active = :isActive " +
	           "AND p.member.member_id = :memberId " +
	           "AND p.category.category_id = :categoryId ")
	int countByConditions(@Param("isActive") int isActive, 
						@Param("memberId") int memberId, 
						@Param("categoryId") int categoryId);
}
