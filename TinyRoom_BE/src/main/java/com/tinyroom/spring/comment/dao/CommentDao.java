package com.tinyroom.spring.comment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.post.domain.Post;


public  interface  CommentDao extends JpaRepository<Comment, Integer> {
	 // 특정 포스트의 모든 댓글을 가져오는 쿼리
    List<Comment> findByPost(Post post);

    List<Comment> findByPostOrderByDateDesc(Post post);
	int countByPost(Post post);

}
