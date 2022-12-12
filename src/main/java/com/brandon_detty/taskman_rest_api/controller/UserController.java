package com.brandon_detty.taskman_rest_api.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandon_detty.taskman_rest_api.dto.UserDto;
import com.brandon_detty.taskman_rest_api.exception.ResourceNotFoundException;
import com.brandon_detty.taskman_rest_api.model.User;
import com.brandon_detty.taskman_rest_api.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepo;

    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return user.get();
    }

    @PostMapping("/user")
    public User createUser() {
        User user = new User();
        user.setCreated(new Date());
        user.setEmail("test@user.com");
        user.setFirstName("Test");
        user.setLastName("User");

        userRepo.save(user);

        return user;
    }

    @PutMapping("/user/{id}")
    public UserDto updateUser(@PathVariable("id") long id) {
        UserDto user = new UserDto(0, "username_placeholder");
        return user;
    }

    @DeleteMapping("/user")
    public boolean deleteUser(@PathVariable("id") long id) {
        return true;
    }
}