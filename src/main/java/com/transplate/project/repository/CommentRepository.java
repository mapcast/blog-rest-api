package com.transplate.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transplate.project.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByIsDeletedFalse();
	
	Optional<Comment> findByRownumberAndIsDeletedFalse(long rownumber);
	
	Optional<Comment> findByUuidAndIsDeletedFalse(String uuid);
	
	Optional<Comment> findByUuidAndWriterPasswordAndIsDeletedFalse(String uuid, String writerPassword);
	
	Optional<Comment> findByUuidAndWriterIdAndIsDeletedFalse(String uuid, String writerId);
	
	List<Comment> findByPostIdAndIsDeletedFalse(String uuid);
	
}
