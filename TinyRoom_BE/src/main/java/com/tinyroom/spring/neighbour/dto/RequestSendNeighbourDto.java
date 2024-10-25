package com.tinyroom.spring.neighbour.dto;

import com.tinyroom.spring.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestSendNeighbourDto {
	private int to_member_id;
	private String message;
}
