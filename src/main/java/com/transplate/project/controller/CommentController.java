package com.transplate.project.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transplate.project.dto.CommentDto;
import com.transplate.project.model.Comment;
import com.transplate.project.model.Post;
import com.transplate.project.service.comment.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
	
	private final CommentService commentService;
	
	@GetMapping("/comments")
	public List<Comment> getComments() {
		return commentService.getComments();
	}
	
	@GetMapping("/comments/{pageId}")
	public Page<Comment> getCommentByUuid(@PathVariable String postId, Pageable pageable) {
		List<Comment> comments =  commentService.getCommentByPostId(postId);
		final int start = (int) pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), comments.size());
		final Page<Comment> page = new PageImpl<>(comments.subList(start, end), pageable, comments.size());
		
		return page;
	}
	
	@PostMapping("/comments")
	public String writeComment(@RequestHeader String Authorization, @RequestBody CommentDto dto) {
		commentService.writeComment("", dto);
		return "{\"success\":true}";
	}
	
	@PutMapping("/comments")
	public String updateComment(@RequestHeader String Authorization, @RequestBody CommentDto dto) {
		commentService.updateComment("", dto);
		return "{\"success\":true}";
	}
	
	@DeleteMapping("/comments/{uuid}")
	public String deleteComment(@RequestHeader String Authorization, @PathVariable String uuid) {
		commentService.deleteComment("", uuid);
		return "{\"success\":true}";
	}
}
