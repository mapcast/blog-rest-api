package com.transplate.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transplate.project.dto.CommentDto;
import com.transplate.project.model.Comment;
import com.transplate.project.service.comment.CommentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
	
	@GetMapping("/comments/{uuid}")
	public Comment getCommentByUuid(@PathVariable String uuid) {
		return commentService.getCommentByUuid(uuid);
	}
	
	@PostMapping("/comments")
	public String writeComment(@RequestHeader String Authorization, @RequestBody CommentDto dto) {
		commentService.writeComment("", dto);
		return "success";
	}
	
	@PutMapping("/comments")
	public String updateComment(@RequestHeader String Authorization, @RequestBody CommentDto dto) {
		commentService.updateComment("", dto);
		return "success";
	}
	
	@DeleteMapping("/comments/{uuid}")
	public String deleteComment(@RequestHeader String Authorization, @PathVariable String uuid) {
		commentService.deleteComment("", uuid);
		return "success";
	}
}
