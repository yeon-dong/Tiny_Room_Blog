package com.tinyroom.spring.neighbour.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.neighbour.domain.Neighbour;
import com.tinyroom.spring.neighbour.dto.NeighbourPageDto;
import com.tinyroom.spring.neighbour.dto.NeighbourPageDto2;

public interface NeighbourDao extends JpaRepository<Neighbour, Integer>{
	   // 특정 member와 일치하는 to_member의 Neighbour 목록을 반환하는 쿼리
    @Query("SELECT n FROM Neighbour n WHERE n.toMember = :member AND n.status = 0")
    List<Neighbour> findByToMember(@Param("member") Member member);

    @Query("SELECT n FROM Neighbour n WHERE (n.fromMember = :member OR n.toMember = :member) AND n.status = 1")
	List<Neighbour> findByMember(@Param("member") Member member);

    @Query("SELECT new com.tinyroom.spring.neighbour.dto.NeighbourPageDto(n.neighbour_id, n.fromMember, n.message) " +
	  		   "FROM Neighbour n " +
	           "WHERE n.toMember = :member " +
	           "AND n.status = 0 " +
	           "ORDER BY n.neighbour_id DESC ")
	Page<NeighbourPageDto> findByConditions(@Param("member") Member member, Pageable pageable);
	  
    @Query("SELECT COUNT(*) FROM Neighbour n WHERE n.toMember = :member ")
	int countByConditions(@Param("member") Member member);

    @Query("SELECT new com.tinyroom.spring.neighbour.dto.NeighbourPageDto2(n.neighbour_id, " +
    	       "CASE WHEN n.fromMember = :member THEN n.toMember ELSE n.fromMember END, " +
    	       "n.message) " +
    	       "FROM Neighbour n " +
    	       "WHERE (n.fromMember = :member OR n.toMember = :member) " +
    	       "AND n.status = 1 " +
    	       "ORDER BY n.neighbour_id DESC")
	Page<NeighbourPageDto2> findByConditions2(@Param("member") Member member, Pageable pageable);

    @Query("SELECT COUNT(*) FROM Neighbour n WHERE (n.fromMember = :member OR n.toMember = :member) ")
	int countByConditions2(@Param("member")Member member);
}
