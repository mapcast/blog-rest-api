package com.transplate.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transplate.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(String userId);
}
