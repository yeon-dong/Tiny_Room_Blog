package com.tinyroom.spring.post.dto;

import com.tinyroom.spring.post.domain.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ResponseCalendarDto {
	private int post_id;
	private int category_id;
	private int day;
	private String title;
	private String content;
	private String thumbnail;
	private String text_content;

}
