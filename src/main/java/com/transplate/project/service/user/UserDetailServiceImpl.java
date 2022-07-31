package com.transplate.project.service.user;

import org.springframework.stereotype.Service;

import com.transplate.project.model.User;
import com.transplate.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service("userDetailService")
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailService {

	private final UserRepository userRepository;
	
	@Override
	public User getUserByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
}
