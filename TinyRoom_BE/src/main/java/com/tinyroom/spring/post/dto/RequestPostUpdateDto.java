package com.tinyroom.spring.post.dto;

import java.util.List;

import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.post.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//post 수정 시 request 값을 받아올 dto

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestPostUpdateDto {
	int category_id;
	String date; //String 으로 받아와서 date로 변경하여 저장할 예정
	String title;
	String content;
	String post_img;
}
