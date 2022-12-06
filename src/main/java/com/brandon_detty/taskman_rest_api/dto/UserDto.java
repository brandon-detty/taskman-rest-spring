package com.brandon_detty.taskman_rest_api.dto;

public class UserDto {
    public long id;
    public String username;

    public UserDto(long id, String username) {
        this.id = id;
        this.username = username;
    }
}