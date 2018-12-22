package com.example.demo.rest;

import com.example.demo.security.UnauthorizedException;
import com.example.demo.security.UserSecurityManager;
import com.example.demo.user.model.User;
import com.example.demo.user.UserService;
import com.example.demo.user.validation.UserValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserSecurityManager userSecurityManager;


    @Autowired
    public UserController(UserSecurityManager userSecurityManager) {
        this.userSecurityManager = userSecurityManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userSecurityManager.getUsers();

        return ResponseEntity.ok(users);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            Long id = userSecurityManager.addUser(user);

            return ResponseEntity.ok(String.valueOf(id));
        } catch (UserValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}

