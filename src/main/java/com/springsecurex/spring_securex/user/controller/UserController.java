package com.springsecurex.spring_securex.user.controller;

import com.springsecurex.spring_securex.user.dto.request.CreateUserRequest;
import com.springsecurex.spring_securex.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.createUser(createUserRequest));
    }
}
