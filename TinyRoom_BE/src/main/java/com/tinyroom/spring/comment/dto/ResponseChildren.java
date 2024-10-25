package com.tinyroom.spring.comment.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseChildren {
	private int commentId;
	private String username;
	private String content;
	private String date;
	private int postId;
	private Integer parentId;
	
	public ResponseChildren(Integer commentId, String nickname, String content, Integer postId, LocalDate date, Integer parentId) {
		this.commentId = commentId;
		this.content = content;
		this.postId = postId;
		this.parentId = parentId;
		this.username = nickname;
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		this.date = format.format(date);
		this.date = date.toString();
	}
}
