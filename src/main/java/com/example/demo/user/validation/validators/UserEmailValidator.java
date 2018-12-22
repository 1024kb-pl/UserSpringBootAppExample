package com.example.demo.user.validation.validators;

import com.example.demo.user.model.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserEmailValidator implements UserValidator {


    @Override
    public List<String> validate(User user) {
        final String email = user.getEmail();

        if (email.isEmpty()) {
            return Collections.singletonList("User email cannot be empty!");
        }

        if (!email.contains("@")) {
            return Collections.singletonList("User should pass correct address email!");
        }

        return Collections.emptyList();
    }
}
