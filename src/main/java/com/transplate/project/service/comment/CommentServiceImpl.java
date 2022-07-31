package com.transplate.project.service.comment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.transplate.project.dto.CommentDto;
import com.transplate.project.model.Comment;
import com.transplate.project.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service("commentService")
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	
private final CommentRepository commentRepository;
	
	@Override
	public List<Comment> getComments() {
		return commentRepository.findByIsDeletedFalse();
	}
	
	@Override
	public Comment getCommentByUuid(String uuid) {
		Optional<Comment> wrapped = commentRepository.findByUuidAndIsDeletedFalse(uuid);
		if(wrapped.isPresent()) {
			return wrapped.get();
		} else {
			return null;
		}
	}
	
	@Override
	public void writeComment(String token, CommentDto dto) {
		
	}
	
	@Override
	public void updateComment(String token, CommentDto dto) {
		
	}
	
	@Override
	public void deleteComment(String token, String uuid) {
		
	}

}
