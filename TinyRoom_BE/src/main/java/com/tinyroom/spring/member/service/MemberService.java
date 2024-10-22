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
import com.tinyroom.spring.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
@Transactional
public class MemberService {
	
	// MemberDao 사용하기 위해 MemberDao 자동으로 주입
	@Autowired
	private MemberDao dao;
	
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
		
		// 생성한 엔티티를 dao로 넘겨서 데이터 저장
		dao.save(member);
	}

	// id로 검색
		public MemberDto getMember(String id) {
			// dao.findById(pk): pk기준으로 검색
			Member m = dao.findByEmail(id).orElse(null);// orElse(null): 검색결과 없으면 널 반환
			if (m == null) {
				return null;
			}
			return new MemberDto(m.getEmail(), m.getPw(), m.getName(), m.getNickname(), m.getPhone_number(), m.getType());
		}
	
}
