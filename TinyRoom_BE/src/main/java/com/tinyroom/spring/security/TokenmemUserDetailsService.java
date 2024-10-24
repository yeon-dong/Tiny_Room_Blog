package com.tinyroom.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service // 인증 객체의 username으로 db에서 검색하여 유효한지 확인해주는 기능 제공
public class TokenmemUserDetailsService implements UserDetailsService {
	@Autowired
	private MemberDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Member m = dao.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("not found id:" + username));
		
		return new TokenUserDetails(m);
	}
}
