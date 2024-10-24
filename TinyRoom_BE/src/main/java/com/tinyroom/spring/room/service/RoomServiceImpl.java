package com.tinyroom.spring.room.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.blog.dao.BlogDao;
import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.blog.service.BlogService;
import com.tinyroom.spring.room.dao.RoomDao;
import com.tinyroom.spring.room.domain.Room;
import com.tinyroom.spring.room.dto.RoomDto;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private BlogService blogService;

	public RoomDto getRoom(Blog blog) {
		Room room = roomDao.findByBlog(blog).orElse(null);// orElse(null): 검색결과 없으면 널 반환
	      
	      if (room== null) {
	         return null;
	      }
	      return roomEntityToDto(room);
	}
	
	@Override
	public RoomDto roomEntityToDto(Room room) {
		RoomDto roomDto = RoomDto.builder()
				.room_id(room.getRoom_id())
				.blog_id(room.getBlog().getBlog_id())
				.room_theme(room.getRoom_theme())
				.furniture1(room.getFurniture1())
				.furniture2(room.getFurniture2())
				.furniture3(room.getFurniture3())
				.furniture4(room.getFurniture4())
				.build();
		
		return roomDto;
	}

	@Override
	public Room roomDtoToEntity(RoomDto roomDto) {
		Room room = Room.builder()
				.room_id(roomDto.getRoom_id())
				.blog(blogDao.findById(roomDto.getBlog_id()).orElse(null))
				.room_theme(roomDto.getRoom_theme())
				.furniture1(roomDto.getFurniture1())
				.furniture2(roomDto.getFurniture2())
				.furniture3(roomDto.getFurniture3())
				.furniture4(roomDto.getFurniture4())
				.build();
		
		return room;
	}
	
}
