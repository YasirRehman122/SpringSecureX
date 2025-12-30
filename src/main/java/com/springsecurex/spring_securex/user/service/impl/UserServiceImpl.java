package com.springsecurex.spring_securex.user.service.impl;

import com.springsecurex.spring_securex.auth.dto.request.AuthenticateRequest;
import com.springsecurex.spring_securex.user.dto.request.CreateUserRequest;
import com.springsecurex.spring_securex.user.dto.response.CreateUserResponse;
import com.springsecurex.spring_securex.user.model.User;
import com.springsecurex.spring_securex.user.repository.UserRepository;
import com.springsecurex.spring_securex.user.service.UserService;
import com.springsecurex.spring_securex.utility.mappers.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public User loadUserByUsername(String username){
        return userRepository.findByUsernameAndActiveTrue(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        userRepository.findByUsernameAndActiveTrue(request.getUsername())
                .ifPresent((user) -> {
                    throw new IllegalArgumentException("Username already exists");
                });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public boolean validateUser(AuthenticateRequest request) {
        User user = userRepository.findByUsernameAndActiveTrue(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Username/Password is incorrect"));
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("Username/Password is incorrect");
        }
        return true;
    }
}
