package com.example.demo1.service;

import com.example.demo1.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
}
