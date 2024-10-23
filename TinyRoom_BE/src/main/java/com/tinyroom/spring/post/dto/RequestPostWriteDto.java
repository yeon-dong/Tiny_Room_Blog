package com.tinyroom.spring.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestPostWriteDto {
	int category_id;
	String date; //String 으로 받아와서 date로 변경하여 저장할 예정
	String title;
	String content;
	String post_img;
}
