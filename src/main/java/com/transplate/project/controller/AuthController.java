package com.transplate.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transplate.project.dto.JoinDto;
import com.transplate.project.dto.LoginDto;
import com.transplate.project.model.User;
import com.transplate.project.service.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserService userService;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDto dto) throws Exception {
		String token = userService.login(dto);
		return token; 
	}
	
	@PostMapping("/join")
	public String join(@RequestBody JoinDto dto) throws Exception {
		userService.join(dto);
		return "SUCCESS";
	}
	
	@GetMapping("/user")
	public User getUserByUserId(@RequestParam String userId) {
		return userService.getUserByUserId(userId);
	}
}
