package com.user.service;

import com.user.model.User;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User addUser(User user) {
        return userRepository.save(user);
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public User getUser(long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()->new Exception("No User with Id: "+userId));
        return user;
    }


    public boolean deleteUser(long userId) {
        userRepository.deleteById(userId);
        return true;
    }


    public User updateUser(long userId, User user) {
        return userRepository.save(user);
    }
}
