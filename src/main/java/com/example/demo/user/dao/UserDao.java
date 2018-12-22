package com.example.demo.user.dao;

import com.example.demo.user.model.User;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component
public class UserDao {
    private List<User> users = new LinkedList<>();

    public Long addUser(User user) {
        Long id = getNextId();
        user.setId(id);

        users.add(user);

        return id;
    }

    private Long getNextId() {
        return Long.valueOf(users.size());
    }

    public List<User> getUsers() {
        return new LinkedList<>(users);
    }

}



