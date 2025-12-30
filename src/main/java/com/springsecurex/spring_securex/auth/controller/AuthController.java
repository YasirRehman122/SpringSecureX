package com.springsecurex.spring_securex.auth.controller;

import com.springsecurex.spring_securex.auth.dto.request.AuthenticateRequest;
import com.springsecurex.spring_securex.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest request){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.validateUser(request));
    }
}
