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
	
	// 역할 목록을 포함하여 이메일로 회원을 조회하는 메서드
	@EntityGraph(attributePaths = ("memberRoleList"))	// memberRoleList를 함께 로드하여 N+1 문제 방지
	@Query("select m from Member m where m.email = :email")	// JPQL을 사용하여 이메일로 회원 조회
	Member getWithRole(@Param("email") String email);	// 주어진 이메일로 회원 정보를 반환
}
