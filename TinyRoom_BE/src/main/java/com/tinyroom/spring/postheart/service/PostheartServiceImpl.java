package com.tinyroom.spring.postheart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.post.dao.PostDao;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.postheart.dao.PostheartDao;

@Service
public class PostheartServiceImpl implements PostheartService{
	@Autowired
	private PostheartDao postheartDao;
	
	@Override
	public int getCount(Post post) {
		return postheartDao.countByPost(post);
	}

	

}
