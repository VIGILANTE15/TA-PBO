package controllers;

import java.util.List;
import java.util.ArrayList;

import models.User;

public class UserController {
    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public void registerUser(String username, String phone, String password, List<String> addresses, boolean isAdmin) {
        users.add(new User(username, phone, password, addresses, isAdmin));
    }

    public User findUser(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    public User loginUser(String username, String password) throws Exception {
        User user = users.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst().orElse(null);
        if (user == null) {
            throw new Exception("Invalid username atau password.");
        }
        return user;
    }
}