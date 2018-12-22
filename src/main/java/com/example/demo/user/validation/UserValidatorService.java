package com.example.demo.user.validation;

import com.example.demo.user.model.User;
import com.example.demo.user.validation.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserValidatorService {

    private List<UserValidator> userValidators;

    @Autowired
    public UserValidatorService(List<UserValidator> validators) {
        this.userValidators = validators;
    }

    public void validate(User user) {
        List<String> result = userValidators.stream()
                .map(validator -> validator.validate(user))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (!result.isEmpty()) {
            throw new UserValidationException(String.join(", ", result));
        }

    }
}
