package com.example.demo1.service;

import com.example.demo1.dao.UserRepository;
import com.example.demo1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserRepository userRepository;

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }
}
