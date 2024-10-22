package com.tinyroom.spring.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.domain.MemberRole;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
@Transactional
public class MemberService {
	
	// MemberDao 사용하기 위해 MemberDao 자동으로 주입
	@Autowired
	private MemberDao memberDao;
	
	// 패스워드 암호화를 위한 PasswordEncoder 자동으로 주입
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 회원가입
	public void register(Map<String, String> map) {
		// Member 엔티티 생성
		Member member = Member.builder()
				.email(map.get("email"))
				.pw(passwordEncoder.encode(map.get("pw")))
				.name(map.get("name"))
				.nickname(map.get("nickname"))
				.phone_number(map.get("phone_number"))
				.build();
		
		// USER 권한 부여
		member.addRole(MemberRole.USER);
		
		// 생성한 엔티티를 dao로 넘겨서 데이터 저장
		memberDao.save(member);
	}
	
}
