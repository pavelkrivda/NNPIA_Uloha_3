package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user){
        users.add(user);
    }

    @Override
    public List<User> getUsers(){
        return  users;
    }
}
