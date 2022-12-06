package com.brandon_detty.taskman_rest_api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandon_detty.taskman_rest_api.dto.UserDto;
import com.brandon_detty.taskman_rest_api.exception.ResourceNotFoundException;

@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public UserDto user(@PathVariable("id") long id) {
        if (id == 0) {
            throw new ResourceNotFoundException();
        }
        UserDto user = new UserDto(id, "username_placeholder");
        return user;
    }

    @PostMapping("/user")
    public UserDto createUser() {
        UserDto user = new UserDto(0, "username_placeholder");
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