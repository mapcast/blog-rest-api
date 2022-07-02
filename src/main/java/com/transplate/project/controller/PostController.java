package com.transplate.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post/v1")
public class PostController {
	@GetMapping("/posts")
	public String getPosts() {
		return "test";
	}
}
