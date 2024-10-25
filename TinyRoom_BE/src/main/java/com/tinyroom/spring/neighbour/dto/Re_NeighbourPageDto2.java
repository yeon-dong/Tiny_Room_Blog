package com.tinyroom.spring.neighbour.dto;

import com.tinyroom.spring.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Re_NeighbourPageDto2 {
	private String blog_name;
	private int member_id;
	private String nickname;
	private String message;
	private String description;
	private String profile_img;
}
