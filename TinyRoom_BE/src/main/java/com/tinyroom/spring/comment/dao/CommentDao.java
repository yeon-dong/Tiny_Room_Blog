package com.tinyroom.spring.comment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinyroom.spring.comment.domain.Comment;


public  interface  CommentDao extends JpaRepository<Comment, Integer> {

	@Query("select c from Comment c where c.post.id = :postId")
	List<Comment> findAllByPost_id(@Param("postId") Integer postId);

}
