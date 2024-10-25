package com.tinyroom.spring.neighbour.dto;

import com.tinyroom.spring.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;

//이웃 목록 조회 pagenation
@AllArgsConstructor
@Getter
public class NeighbourPageDto2 {
	  private int neighbourId;
	  private Member fromMember;
	  private String message;
}
