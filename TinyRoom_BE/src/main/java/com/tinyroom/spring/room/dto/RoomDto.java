package com.tinyroom.spring.room.dto;

import com.tinyroom.spring.blog.dto.BlogDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class RoomDto {
	
	private int room_id;
	private int blog_id;
	private int room_theme;
	private int furniture1;
	private int furniture2;
	private int furniture3;
	private int furniture4;
}
