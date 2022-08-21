package com.transplate.project.service.post;

import java.util.List;

import com.transplate.project.dto.PostDto;
import com.transplate.project.model.Post;

public interface PostService {
	List<Post> getPosts();
	List<Post> getPostsByCategory(String category);
	Post getPostByUuid(String uuid);
	void writePost(String token, PostDto dto);
	void updatePost(String token, PostDto dto);
	void deletePost(String token, String uuid);
	Post getLastPost(String category);
	
}
