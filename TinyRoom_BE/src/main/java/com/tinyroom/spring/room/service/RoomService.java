package com.tinyroom.spring.room.service;

import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.room.domain.Room;
import com.tinyroom.spring.room.dto.RoomDto;

public interface RoomService {
	
	public RoomDto getRoom(Blog blog);
	
	RoomDto roomEntityToDto(Room room);
	Room roomDtoToEntity(RoomDto roomDto);
}
