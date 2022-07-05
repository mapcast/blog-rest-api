package com.transplate.project.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.transplate.project.dto.PostDto;
import com.transplate.project.model.Post;
import com.transplate.project.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service("postService")
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	
	private final PostRepository postRepository;
	
	@Override
	public List<Post> getPosts(String token) {
		return postRepository.findByIsDeletedFalse();
	}
	
	@Override
	public Post getPostByUuid(String token, String uuid) {
		Optional<Post> wrapped = postRepository.findByUuidAndIsDeletedFalse(uuid);
		if(wrapped.isPresent()) {
			return wrapped.get();
		} else {
			return null;
		}
	}
	
	@Override
	public void writePost(String token, PostDto dto) {
		Post post = new Post();
		post.setUuid(UUID.randomUUID().toString());
		post.setSubject(dto.getSubject());
		post.setContents(dto.getContents());
		post.setCategory(dto.getCategory());
		postRepository.save(post);
	}
	
	@Override
	public void updatePost(String token, PostDto dto) {
		Optional<Post> wrapped = postRepository.findByUuidAndIsDeletedFalse(dto.getUuid());
		if(wrapped.isPresent()) {
			Post post = wrapped.get();
			post.setSubject(dto.getSubject());
			post.setContents(dto.getContents());
			post.setCategory(dto.getCategory());
			postRepository.save(post);
		}
	}
	
	@Override
	public void deletePost(String token, String uuid) {
		Optional<Post> wrapped = postRepository.findByUuidAndIsDeletedFalse(uuid);
		if(wrapped.isPresent()) {
			Post post = wrapped.get();
			post.setIsDeleted(true);
			postRepository.save(post);
		}
	}
	
	
}
