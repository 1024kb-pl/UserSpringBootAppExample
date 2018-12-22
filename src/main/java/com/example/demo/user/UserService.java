package com.example.demo.user;

import com.example.demo.user.model.User;
import com.example.demo.user.dao.UserDao;
import com.example.demo.user.validation.UserValidationException;
import com.example.demo.user.validation.UserValidatorService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private UserDao userDao;
    private UserValidatorService userValidator;
    private Logger logger;

    @Autowired
    public UserService(UserDao userDao, Logger logger, UserValidatorService userValidator) {
        this.userDao = userDao;
        this.logger = logger;
        this.userValidator = userValidator;
    }

    public List<User> getUsers() {
        logger.info("Get users");
        return userDao.getUsers();
    }

    public Long addUser(User user) {
        logger.info("Creating user: {}", user);

        validateUser(user);

        Long id = userDao.addUser(user);

        logger.info("Created user successfully: {}", user);
        return id;
    }

    private void validateUser(User user) {
        try {
            userValidator.validate(user);
        } catch (UserValidationException e) {
            logger.error("User cannot be added due to validation: {}", e.getMessage());
            throw e;
        }
    }
}
