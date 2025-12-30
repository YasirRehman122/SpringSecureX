package com.springsecurex.spring_securex.user.service;

import com.springsecurex.spring_securex.auth.dto.request.AuthenticateRequest;
import com.springsecurex.spring_securex.user.dto.request.CreateUserRequest;
import com.springsecurex.spring_securex.user.dto.response.CreateUserResponse;
import com.springsecurex.spring_securex.user.model.User;

public interface UserService {
    User loadUserByUsername(String username);
    CreateUserResponse createUser(CreateUserRequest request);

    boolean validateUser(AuthenticateRequest request);
}
