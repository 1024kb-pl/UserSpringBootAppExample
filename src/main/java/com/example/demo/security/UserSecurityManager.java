package com.example.demo.security;

import com.example.demo.user.UserService;
import com.example.demo.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSecurityManager {


    private UserService userService;


    @Autowired
    public UserSecurityManager(UserService userService) {
        this.userService = userService;
    }


    public Long addUser(User user) {
        // security layer -> e.g check JWT, if user doesnt have access to resource should return UnauthorizedException
        return userService.addUser(user);
    }


    public List<User> getUsers() {
        // security layer -> e.g check JWT, if user doesnt have access to resource should return UnauthorizedException
        return userService.getUsers();
    }
}
