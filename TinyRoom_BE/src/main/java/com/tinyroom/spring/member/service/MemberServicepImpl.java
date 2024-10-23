//package com.tinyroom.spring.member.service;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.tinyroom.spring.member.dao.MemberDao;
//import com.tinyroom.spring.member.domain.Member;
//import com.tinyroom.spring.member.dto.MemberDto;
//
//@Service
//public class MemberServicepImpl implements MemberService{
//	
//	// MemberDao 사용하기 위해 MemberDao 자동으로 주입
//	@Autowired
//	private MemberDao dao;
//	// 패스워드 암호화를 위한 PasswordEncoder 자동으로 주입
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Override
//	public void register(Map<String, String> map) {
//		// Member 엔티티 생성
//				Member member = Member.builder()
//						.email(map.get("email"))
//						.pw(passwordEncoder.encode(map.get("pw")))
//						.name(map.get("name"))
//						.nickname(map.get("nickname"))
//						.phone_number(map.get("phone_number"))
//						.build();
//				
//				// 생성한 엔티티를 dao로 넘겨서 데이터 저장
//				dao.save(member);
//		
//	}
//
//	@Override
//	public MemberDto getMember(String id) {
//		// dao.findById(pk): pk기준으로 검색
//		Member m = dao.findByEmail(id).orElse(null);// orElse(null): 검색결과 없으면 널 반환
//		if (m == null) {
//			return null;
//		}
//		return entityMemberDto(m);
//	}
//
//}
