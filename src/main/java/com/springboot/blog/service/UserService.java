package com.springboot.blog.service;

import com.springboot.blog.model.User;
import com.springboot.blog.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void deleteAll(){

    }

}
