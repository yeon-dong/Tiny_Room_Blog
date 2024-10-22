package com.tinyroom.spring.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.dao.PostDao;
import com.tinyroom.spring.post.domain.Post;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class PostTest {
	@Autowired
	PostDao postDao;
	
	@Autowired
	MemberDao memberDao;
	


}
