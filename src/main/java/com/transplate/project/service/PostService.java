package com.transplate.project.service;

import java.util.List;

import com.transplate.project.dto.PostDto;
import com.transplate.project.model.Post;

public interface PostService {
	List<Post> getPosts(String token);
	Post getPostByUuid(String token, String uuid);
	void writePost(String token, PostDto dto);
	void updatePost(String token, PostDto dto);
	void deletePost(String token, String uuid);
	
}
