package com.tinyroom.spring.blog.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Builder
public class PostPageDto {
	private int postId;
	private LocalDate date;
	private LocalDate w_date;
	private String title;
	private String textContent;
	private String thumbnail;
	private int memberId;
}
