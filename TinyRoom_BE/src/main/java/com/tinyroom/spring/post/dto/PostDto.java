package com.tinyroom.spring.post.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.post.domain.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class PostDto {
	private int post_id;
	private Member member;
	private Category category;
	
	private LocalDate date;	
	private LocalDate w_date; // date -> 포스트 작성일자
	private String title;	// 포스트 제목
	private String content;	// 포스트 내용(html 형식)
	private int is_active; // 활성화 여부(삭제 여부) : 삭제했을 때 db에서 실제로 삭제되는 것이 아니라 상태값으로 관리

	private String thumbnail;
	private String text_content;

	
}
