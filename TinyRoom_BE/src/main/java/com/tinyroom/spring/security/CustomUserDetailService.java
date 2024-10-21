package com.tinyroom.spring.security;

import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
	private final MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("---------------------------load user username ---------------------------" + username);
		
		Member member = memberDao.getWithRole(username);
		
		if(member == null) {
			throw new UsernameNotFoundException("not found");
		}
		
		MemberDto memberDto = new MemberDto(
				member.getEmail(),
				member.getPw(),
				member.getMemberRoleList()
					.stream().map(memberRole -> memberRole.name())
					.collect(Collectors.toList()));
	
		
		log.info(memberDto);
		
		
		return memberDto;	
	}
	
}
