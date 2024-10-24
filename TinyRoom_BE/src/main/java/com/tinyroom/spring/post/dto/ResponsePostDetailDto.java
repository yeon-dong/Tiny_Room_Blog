package com.tinyroom.spring.post.dto;

import java.time.LocalDate;
import java.util.List;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.domain.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ResponsePostDetailDto {
	//post 상세조회 response 응답 담는 dto
	private Post post;
	private int heartCount;
	private int commentCount;
}
