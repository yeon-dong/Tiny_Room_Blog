package com.tinyroom.spring.post.dto;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponsePostMainDto {
	private UserDto user;
	private int postId;
	private String thumbnail;
	private String title;
	private String content;
	private String textContent;
	private int heartCount;
	private int commentCount;
	
	public ResponsePostMainDto(long member_id, String nickname, String profile_img, long post_id, String thumbnail, String title,
			String content, String text_content, long heartCount, long commentCount) {
		this.user = UserDto.builder()
				.userId((int)member_id)
				.nickname(nickname)
				.profileImg(profile_img)
				.build();
		this.postId = (int)post_id;
		this.thumbnail = thumbnail;
		this.title = title;
		this.content = content;
		this.textContent = text_content;
		this.heartCount = (int)heartCount;
		this.commentCount = (int)commentCount;
	}
	
	
	
	
	
	
	
	
}
