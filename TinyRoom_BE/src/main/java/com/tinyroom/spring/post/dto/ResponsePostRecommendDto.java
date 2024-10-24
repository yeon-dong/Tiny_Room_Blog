package com.tinyroom.spring.post.dto;

import com.tinyroom.spring.category.dto.CategoryDto;
import com.tinyroom.spring.post.domain.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Builder
public class ResponsePostRecommendDto {
	private int post_id;
	private String title;
	private String thumbnail;
	private String text_content;
	private String content;
	private String post_img;
	private String nickname;
	private int heartCount;
	private int commentCount;
}
