package com.tinyroom.spring.room.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.room.domain.Room;

@Repository
public interface RoomDao extends JpaRepository<Room, Integer> {

	Optional<Room> findByBlog(Blog blog);	// 블로그 id로 Room 정보 조회
}
