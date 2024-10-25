package com.tinyroom.spring.member.dto;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.dto.ResponsePostMainDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
	private int userId;
	private String nickname;
	private String profileImg;
}
