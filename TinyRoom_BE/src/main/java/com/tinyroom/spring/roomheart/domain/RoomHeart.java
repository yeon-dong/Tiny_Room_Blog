package com.tinyroom.spring.roomheart.domain;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.room.domain.Room;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RoomHeart {
	// room_heart_id -> 방 좋아요 식별자 (PK)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_heart_id;
	
	// member_id -> Member와 1:N 관계 (N 쪽) : 좋아요 누른 사람
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	// room_id -> Room와 1:N 관계 (N 쪽) : 좋아요 누른 방
	@ManyToOne
	@JoinColumn(name="room_id")
	private Room room;
}
