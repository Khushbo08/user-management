package com.user.controller;

import com.user.model.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {
    @Autowired
    private UserService userService;


    //To Add User
    @PostMapping("adduser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User user1 = userService.addUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    //To Get all User
    @GetMapping("list")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }

    //To Get User
    @GetMapping("{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") long userId) throws Exception {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    //To delete User
    @DeleteMapping("delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
        return new ResponseEntity<String>("USER ID: "+userId,HttpStatus.OK);
    }

    //To update User
    @PutMapping("update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") long userId,@RequestBody User user) throws Exception {
        user.setId(userId);
        User user1 = userService.updateUser(userId,user);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }

    // Health Check Endpoint
    @GetMapping("health")
    public ResponseEntity<String> checkHealth() {
        boolean isServerRunning = true; //Check if server is running

        if (isServerRunning) {
            return ResponseEntity.status(HttpStatus.OK).body("Server is running"); // HTTP status code 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Server is not running"); // HTTP status code 503 SERVICE_UNAVAILABLE
        }
    }

}
