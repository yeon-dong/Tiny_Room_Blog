package com.tinyroom.spring.comment.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
	private String username;
	private String content;
	private int postId;
	private String date;
	private Integer parentId;
	private List<ResponseChildren> children;
	
	public ResponseCommentListDto(Integer commentId, String nickname, String content, Integer postId, LocalDate date, Integer parentId) {
		this.commentId = commentId;
		this.content = content;
		this.postId = postId;
		this.parentId = parentId;
		this.username = nickname;
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		this.date = format.format(date);
		this.date = date.toString();
		this.children = new ArrayList<>();
	}
}
