package com.tinyroom.spring.comment.service;

import java.util.List;

import com.tinyroom.spring.comment.domain.Comment;

public interface CommentService {
//post에 대한 comment 모두 주기
	public List<Comment> findAll(Integer post_id);
}
