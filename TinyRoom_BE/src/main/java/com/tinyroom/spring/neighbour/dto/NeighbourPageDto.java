package com.tinyroom.spring.neighbour.dto;

import com.tinyroom.spring.member.domain.Member;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NeighbourPageDto {
	private int neighbour_id;
	private Member from_member;
	private String message;
}
