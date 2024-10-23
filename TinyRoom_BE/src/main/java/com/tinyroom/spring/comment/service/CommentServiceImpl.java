package com.tinyroom.spring.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.comment.dao.CommentDao;
import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.post.service.PostService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentDao commentDao;

	@Override
	public List<Comment> findAll(Integer post_id) {
		// TODO Auto-generated method stub
		return commentDao.findAllByPost_id(post_id);
	}
}
