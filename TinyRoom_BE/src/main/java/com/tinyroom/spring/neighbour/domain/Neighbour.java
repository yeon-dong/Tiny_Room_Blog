package com.tinyroom.spring.neighbour.domain;

import java.util.List;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.domain.Post;

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
public class Neighbour {
	// neighbour_id -> 이웃 식별자(PK)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int neighbour_id;
	
	// from_member_id -> Member와 1:N 관계 (N 쪽) : 이웃을 신청한 쪽
	@ManyToOne
	@JoinColumn(name="from_member_id")
	private Member fromMember;
	
	// to_member_id -> Member와 1:N 관계 (N 쪽) : 이웃 신청을 받은 쪽
	@ManyToOne
	@JoinColumn(name="to_member_id")
	private Member toMember;
	
	// status -> 신청 수락 / 거절 상태
	private int status;
	
	private String message;
	
}
