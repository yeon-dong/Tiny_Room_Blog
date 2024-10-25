package com.tinyroom.spring.neighbour.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Re_NeighbourPageDto {
	private String blog_name;
	private int neighbour_id;
	private int member_id;
	private String nickname;
	private String message;
	private String description;
	private String profile_img;
}
