package com.lq.springboot.service;

import com.lq.springboot.entities.User;

import java.util.List;

public interface UserService {

    List<User> getUsers(User user);

    User getById(Integer id);

    void update(User user);

    void save(User user);

    void delete(Integer id);

    User getUserByUserName(String username);
}
