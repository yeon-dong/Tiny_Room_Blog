package com.tinyroom.spring.comment.domain;

import java.time.LocalDate;
import java.util.List;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.neighbour.domain.Neighbour;
import com.tinyroom.spring.post.domain.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Comment {
	// comment_id -> 댓글 식별자(PK)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comment_id;
	
	// content -> 댓글 내용
	private String content;
	// is_active -> 활성화 여부(삭제 여부) : 삭제했을 때 db에서 실제로 삭제되는 것이 아니라 상태값으로 관리
	private int is_active;
	
	// post_id -> Post Entity와 1대N 관계 (FK) : N 쪽 
	 @ManyToOne
	 @JoinColumn(name = "post_id", nullable = false)
	private Post post;
	
	// member_id -> Member Entity와 1대N 관계 (FK) : N 쪽 
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	// parent_id -> Comment Entity(자기 자신)와 1대N 관계 (FK) : N 쪽 
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Comment parent;
	
	// 위에서의 자기 자신과의 관계 설정하는 부분 : 1쪽
	@OneToMany(fetch= FetchType.LAZY, mappedBy = "parent")
	private List<Comment> comments;
	
	private LocalDate date;	
}
