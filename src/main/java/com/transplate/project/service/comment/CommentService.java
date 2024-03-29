package com.transplate.project.service.comment;

import java.util.List;

import com.transplate.project.dto.CommentDto;
import com.transplate.project.model.Comment;

public interface CommentService {

	List<Comment> getComments();

	void writeComment(String token, CommentDto dto);

	void updateComment(String token, CommentDto dto);

	void deleteComment(String token, String uuid);

	List<Comment> getCommentByPostId(String postId);

}
