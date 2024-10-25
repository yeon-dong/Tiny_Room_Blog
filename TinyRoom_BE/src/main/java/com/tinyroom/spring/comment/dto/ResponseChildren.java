package com.tinyroom.spring.comment.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseChildren {
	private int commentId;
	private String content;
	private int postId;
	private Integer parentId;
	
	public ResponseChildren(Integer commentId, String content, Integer postId, Integer parentId) {
		this.commentId = commentId;
		this.content = content;
		this.postId = postId;
		this.parentId = parentId;
	}
}
