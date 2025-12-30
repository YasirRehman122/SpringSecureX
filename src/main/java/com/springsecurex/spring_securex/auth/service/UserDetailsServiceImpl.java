package com.springsecurex.spring_securex.auth.service;

import com.springsecurex.spring_securex.auth.model.SecurityUser;
import com.springsecurex.spring_securex.user.model.User;
import com.springsecurex.spring_securex.user.service.UserService;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@NullMarked
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService){
        this.userService = userService;
    }
    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.loadUserByUsername(username);
        return new SecurityUser(user);
    }
}
