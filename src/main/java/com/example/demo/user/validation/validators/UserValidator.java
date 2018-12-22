package com.example.demo.user.validation.validators;

import com.example.demo.user.model.User;

import java.util.List;

public interface UserValidator {
    List<String> validate(User user);
}
