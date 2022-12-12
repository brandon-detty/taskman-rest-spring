package com.brandon_detty.taskman_rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brandon_detty.taskman_rest_api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}