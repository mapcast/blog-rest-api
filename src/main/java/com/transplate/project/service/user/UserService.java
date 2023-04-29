package com.transplate.project.service.user;

import com.transplate.project.dto.JoinDto;
import com.transplate.project.dto.LoginDto;
import com.transplate.project.model.User;

public interface UserService {

	boolean join(JoinDto dto) throws Exception;

	String login(LoginDto dto) throws Exception;

	User getUserByUserId(String userId);

}
