package com.tinyroom.spring.neighbour.dto;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.neighbour.domain.Neighbour;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NeighbourDto {
	private int neighbour_id;
	private Member from_member;
	private Member to_member;
	private int status;
}
