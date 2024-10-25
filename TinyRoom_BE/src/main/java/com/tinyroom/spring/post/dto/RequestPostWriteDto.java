package com.tinyroom.spring.post.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RequestPostWriteDto {
	private int category_id;
	private String date; //String 으로 받아와서 date로 변경하여 저장할 예정
	private String title;
	private String content;
	private String text_content;
	private String thumbnail;
}
