package com.tinyroom.spring.neighbour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.neighbour.domain.Neighbour;

public interface NeighbourDao extends JpaRepository<Neighbour, Integer>{
	   // 특정 member와 일치하는 to_member의 Neighbour 목록을 반환하는 쿼리
    @Query("SELECT n FROM Neighbour n WHERE n.toMember = :member AND n.status = 0")
    List<Neighbour> findByToMember(@Param("member") Member member);

    @Query("SELECT n FROM Neighbour n WHERE (n.fromMember = :member OR n.toMember = :member) AND n.status = 1")
	List<Neighbour> findByMember(@Param("member") Member member);
}
