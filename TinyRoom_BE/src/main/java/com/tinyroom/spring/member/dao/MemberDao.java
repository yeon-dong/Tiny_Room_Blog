package com.tinyroom.spring.member.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tinyroom.spring.member.domain.Member;

@Repository	// 데이터 접근 객체(DAO)임을 나타내는 어노테이션
public interface MemberDao extends JpaRepository<Member, Integer> {
	
	// 이메일로 회원을 찾는 메서드
	Optional<Member> findByEmail(String email);	// 주어진 이메일로 회원 정보를 조회, 결과는 Optional로 반환
}
