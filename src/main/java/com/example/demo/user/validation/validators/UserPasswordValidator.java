package com.example.demo.user.validation.validators;

import com.example.demo.user.model.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserPasswordValidator implements UserValidator {
    @Override
    public List<String> validate(User user) {
        final String password = user.getPassword();

        if (password.isEmpty()) {
            return Collections.singletonList("User password cannot be empty!");
        }

        if (password.length() < 8) {
            return Collections.singletonList("User password length cannot be less than 8 characters!");
        }

        return Collections.emptyList();
    }
}
