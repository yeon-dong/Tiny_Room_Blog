package com.tinyroom.spring.comment.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinyroom.spring.comment.domain.Comment;
import com.tinyroom.spring.comment.dto.ResponseChildren;
import com.tinyroom.spring.comment.dto.ResponseCommentListDto;
import com.tinyroom.spring.post.domain.Post;


public  interface  CommentDao extends JpaRepository<Comment, Integer> {
	 // 특정 포스트의 모든 댓글을 가져오는 쿼리
    List<Comment> findByPost(Post post);

    List<Comment> findByPostOrderByDateDesc(Post post);
	int countByPost(Post post);

	@Query("SELECT new com.tinyroom.spring.comment.dto.ResponseCommentListDto( " +
			"c.comment_id, c.content, c.post.post_id, c.parent.comment_id " +
			") " +
			"FROM Comment c " + 
			"WHERE c.is_active = 1 " +
			"AND c.post.post_id = :postId " +
			"AND c.parent.comment_id IS NULL " +
			"ORDER BY c.date DESC"
			)
	Page<ResponseCommentListDto> findParentComments(@Param("postId") int postId, Pageable pageable);

	@Query("SELECT new com.tinyroom.spring.comment.dto.ResponseChildren( " +
			"c.comment_id, c.content, c.post.post_id, c.parent.comment_id " +
			") " +
			"FROM Comment c " + 
			"WHERE c.is_active = 1 " +
			"AND c.parent.comment_id = :commentId " +
			"ORDER BY c.date DESC"
			)
	List<ResponseChildren> findChildrenComments(@Param("commentId") int commentId);

	@Query("SELECT COUNT(*) FROM Comment c " +
			"WHERE c.is_active = 1 " +
			"AND c.parent.comment_id IS NULL " +
			"AND c.post.post_id = :postId ")
	int countByCondition(@Param("postId") int postId);

}
