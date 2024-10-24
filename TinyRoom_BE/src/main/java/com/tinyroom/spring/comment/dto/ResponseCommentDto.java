package com.tinyroom.spring.comment.dto;

import java.time.LocalDate;
import java.util.List;

import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCommentDto {
	private int comment_id;
	private int post_id;
	private int member_id;
	private String content;
	private String nickname; //작성자 
	private LocalDate date;	
}
