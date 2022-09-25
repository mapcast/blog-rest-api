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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transplate.project.dto.PostDto;
import com.transplate.project.model.Post;
import com.transplate.project.service.post.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;

	
	@GetMapping("/posts")
	public Page<Post> getPostsByCategory(@RequestParam String category, Pageable pageable) {
		List<Post> posts = postService.getPostsByCategory(category);
		final int start = (int)pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), posts.size());
		final Page<Post> page = new PageImpl<>(posts.subList(start, end), pageable, posts.size());
		
		return page;
	}
	
	@GetMapping("/posts/top1")
	public Post getTopPosts(@RequestParam String category) {
		return postService.getLastPost(category);
	}
	
	@GetMapping("/posts/{uuid}")
	public Post getPostByUuid(@PathVariable String uuid) {
		return postService.getPostByUuid(uuid);
	}
	
	@PostMapping("/posts")
	public String writePost(@RequestHeader String Authorization, @RequestBody PostDto dto) {
		postService.writePost("", dto);
		return "{\"success\":true}";
	}
	
	@PutMapping("/posts")
	public String updatePost(@RequestHeader String Authorization, @RequestBody PostDto dto) {
		postService.updatePost("", dto);
		return "{\"success\":true}";
	}
	
	@DeleteMapping("/posts/{uuid}")
	public String deletePost(@RequestHeader String Authorization, @PathVariable String uuid) {
		postService.deletePost("", uuid);
		return "{\"success\":true}";
	}
}
