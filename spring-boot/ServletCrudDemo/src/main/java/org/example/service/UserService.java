package org.example.service;

import org.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<Integer, User> userDB;

    public UserService() {
        userDB = new HashMap<>();
    }


    public User createUser(User user) {
        userDB.put(
                user.getId(),
                user
        );
        return user;
    }

    public User getUser(User user) {
        userDB.put(
                user.getId(),
                user
        );
        return user;
    }

    public User getUserById(Integer id) {
            return userDB.getOrDefault(
                    id,
                    null
            );
    }

    public List<User> getAllUsers() {
        return userDB.values().stream().toList();
    }
}
