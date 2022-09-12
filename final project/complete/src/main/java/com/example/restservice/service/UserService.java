package com.example.restservice.service;

import com.example.restservice.model.User;
import com.example.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int createUser(User user){
        return this.userRepository.createUser(user);
    }

    public User getUser(){
        return this.userRepository.getUser();
    }
}
