package com.example.demo.user.validation.validators;

import com.example.demo.user.model.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserNameValidator implements UserValidator {
    @Override
    public List<String> validate(User user) {
        final String login = user.getLogin();

        if (login.isEmpty()) {
            return Collections.singletonList("User login cannot be empty!");
        }

        if (login.length() < 6) {
            return Collections.singletonList("User login length cannot be less than 6 characters!");
        }

        return Collections.emptyList();
    }
}
