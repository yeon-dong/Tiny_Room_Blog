package com.tinyroom.spring.post.dto;

import java.util.Date;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.member.domain.Member;

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
	
	private Date date;	
	private Date w_date; // date -> 포스트 작성일자
	private String title;	// 포스트 제목
	private String content;	// 포스트 내용
	private String post_img;	// 포스트 첨부 이미지
	private int is_active; // 활성화 여부(삭제 여부) : 삭제했을 때 db에서 실제로 삭제되는 것이 아니라 상태값으로 관리
}
