package com.transplate.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transplate.project.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByIsDeletedFalse();
	
	List<Post> findByCategoryAndIsDeletedFalse(String category);
	
	Optional<Post> findByRownumberAndIsDeletedFalse(long rownumber);
	
	Optional<Post> findByUuidAndIsDeletedFalse(String uuid);
	
	Optional<Post> findTop1ByCategoryAndIsDeletedFalse(String category);
	
}
