package com.tinyroom.spring.comment.dto;

import java.time.LocalDate;
import java.util.List;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.domain.Post;

import jakarta.persistence.Entity;
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
public class CommentDto {
	private int comment_id;
	private String content;
	private int is_active;
	private Post post;
	private LocalDate date;

	private Member member;
	
	private Comment parent;
	
	private List<Comment> comments;
	
	private LocalDate date;	
}
