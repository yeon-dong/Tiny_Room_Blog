package com.tinyroom.spring.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberTest {
	@Autowired
	MemberDao memberRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManagerBuilder authenticationManagerBuilder;
	
//	@Test
//	public void testInsertMember() {
//		
//		for(int i=0;i<10;i++) {
//			
//			Member member = Member.builder()
//					.email("user"+ i +"@han.com")
//					.pw(passwordEncoder.encode("1234"))
//					.nickname("user"+i)
//					.type("ROLE_USER")
//					.build();
//			
//			memberRepository.save(member);
//		}
//	}
	
	
//	@Test
//	public void testRead() {
//		String email = "user1@han.com";
//		Member member =memberRepository.getWithRole(email);
//		
//		log.info("#######################");
//		log.info(member);
//		log.info(member.getMemberRoleList());
//		
//	}
}
