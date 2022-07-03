package com.transplate.project.service;

import org.springframework.stereotype.Service;

import com.transplate.project.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service("postService")
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	private final PostRepository postRepository;
	
	private boolean insertPost() {
		postRepository.findAll();
		return true;
	}
}
