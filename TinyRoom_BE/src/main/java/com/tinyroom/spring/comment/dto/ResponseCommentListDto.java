package com.tinyroom.spring.comment.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ResponseCommentListDto {
	private int commentId;
	private String content;
	private int postId;
	private Integer parentId;
	private List<ResponseChildren> children;
	
	public ResponseCommentListDto(Integer commentId, String content, Integer postId, Integer parentId) {
		this.commentId = commentId;
		this.content = content;
		this.postId = postId;
		this.parentId = parentId;
		this.children = new ArrayList<>();
	}
}
