package com.tinyroom.spring.comment.service;

import java.util.List;

import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.comment.dto.CommentDto;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PostDto;

public interface CommentService {
//post에 대한 comment 모두 주기
	public List<Comment> findAll(Integer post_id);

	public void addComment(Comment comment);

	public CommentDto getComment(int comment_id);
	
	default CommentDto entityCommentDto(Comment comment) {
		CommentDto commentDto = CommentDto.builder()
				.comment_id(comment.getComment_id())
				.content(comment.getContent())
				.is_active(comment.getIs_active())
				.post(comment.getPost())
				.member(comment.getMember())
				.comments(comment.getComments())
				.build();
		return commentDto;
	}
	
	default Comment dtoToEntity(CommentDto commentDto) {
		Comment comment = Comment.builder()
				.comment_id(commentDto.getComment_id())
				.content(commentDto.getContent())
				.is_active(commentDto.getIs_active())
				.post(commentDto.getPost())
				.member(commentDto.getMember())
				.comments(commentDto.getComments())
				.build();
		return comment;
	}

	public void modify(CommentDto commentDto);

	public void delete(int comment_id);
}
