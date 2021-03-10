package com.example.demo;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();
}
