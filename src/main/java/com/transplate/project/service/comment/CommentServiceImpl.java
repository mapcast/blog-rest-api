package com.transplate.project.service.comment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.transplate.project.dto.CommentDto;
import com.transplate.project.model.Comment;
import com.transplate.project.model.Post;
import com.transplate.project.repository.CommentRepository;
import com.transplate.project.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service("commentService")
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	
	private final CommentRepository commentRepository;

	private final PostRepository postRepository;
	
	@Override
	public List<Comment> getComments() {
		return commentRepository.findByIsDeletedFalse();
	}
	
	@Override
	public List<Comment> getCommentByPostId(String postId) {
		return commentRepository.findByPostIdAndIsDeletedFalse(postId);
	}
	
	@Override
	public void writeComment(String token, CommentDto dto) {
		Comment comment = new Comment();
		comment.setUuid(UUID.randomUUID().toString());
		comment.setWriter(dto.getWriter());
		comment.setWriterId(dto.getWriterId());
		comment.setWriterPassword(dto.getPassword());
		comment.setPostId(dto.getPostId());
		Post post = postRepository.findByUuidAndIsDeletedFalse(dto.getPostId()).get();
		comment.setPost(post);
		comment.setContent(dto.getContent());
		commentRepository.save(comment);
	}
	
	@Override
	public void updateComment(String token, CommentDto dto) {
		if(dto.getWriterId() != null) {
			Optional<Comment> wrapped = commentRepository.findByUuidAndWriterIdAndIsDeletedFalse(dto.getUuid(), dto.getWriterId());
			if(wrapped.isPresent()) {
				Comment comment = wrapped.get();
				comment.setWriter(dto.getWriter());
				comment.setWriterPassword(dto.getPassword());
				comment.setContent(dto.getContent());
				commentRepository.save(comment);
			}
		} else if(dto.getPassword() != null) {
			Optional<Comment> wrapped = commentRepository.findByUuidAndWriterPasswordAndIsDeletedFalse(dto.getUuid(), dto.getPassword());
			if(wrapped.isPresent()) {
				Comment comment = wrapped.get();
				comment.setWriter(dto.getWriter());
				comment.setWriterPassword(dto.getPassword());
				comment.setContent(dto.getContent());
				commentRepository.save(comment);
			}
		}
	}
	
	@Override
	public void deleteComment(String token, String uuid) {
		Optional<Comment> wrapped = commentRepository.findByUuidAndIsDeletedFalse(uuid);
		if(wrapped.isPresent()) {
			Comment comment = wrapped.get();
			comment.setIsDeleted(true);
			commentRepository.save(comment);
		}
	}

}
