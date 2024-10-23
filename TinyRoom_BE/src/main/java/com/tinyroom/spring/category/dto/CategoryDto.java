package com.tinyroom.spring.category.dto;

import java.time.LocalDate;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.dto.PostDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class CategoryDto {
	private int category_id;
	private String category_name;
}
