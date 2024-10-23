package com.tinyroom.spring.postheart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.dao.PostDao;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.postheart.dao.PostheartDao;
import com.tinyroom.spring.postheart.domain.PostHeart;
import com.tinyroom.spring.postheart.dto.PostheartDto;

@Service
public class PostheartServiceImpl implements PostheartService{
	@Autowired
	private PostheartDao postheartDao;
	
	@Override
	public int getCount(Post post) {
		return postheartDao.countByPost(post);
	}

	@Override
	public int addHeart(PostHeart postHeart) {
		postheartDao.save(postHeart);
		return postHeart.getPost_heart_id();
	}

	@Override
	public PostheartDto getHeart(Member member, Post post) {
		 PostHeart postheart = postheartDao.findByMemberAndPost(member, post)
		            .orElse(null); // 없을 경우 null 반환
		 PostheartDto postheartDto =  entityPostheartDto(postheart);
		 
		 return postheartDto;
	}

	@Override
	public void deleteHeart(int post_heart_id) {
		postheartDao.deleteById(post_heart_id);
	}


}
