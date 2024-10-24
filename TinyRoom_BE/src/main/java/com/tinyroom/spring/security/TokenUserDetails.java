package com.tinyroom.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tinyroom.spring.member.domain.Member;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TokenUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Member m;//인증에 사용될 id/pwd/type 등의 정보를 갖는 entity를 멤버로 갖음
	
	public TokenUserDetails(Member m) {//생성자로 의존성 주입
		this.m = m;
	}

	//인증 객체의 권한 목록 저장
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> list = new ArrayList<>();
		log.info("################################# TokenUserDetails 권한 목록 : " + new SimpleGrantedAuthority(m.getType()) + "##################");
		list.add(new SimpleGrantedAuthority(m.getType()));
		return list;
	}

	@Override
	public String getPassword() {//인증 객체의 pwd 반환
		// TODO Auto-generated method stub
		return m.getPw();
	}

	@Override
	public String getUsername() {//인증 객체의 id 반환
		// TODO Auto-generated method stub
		return m.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
