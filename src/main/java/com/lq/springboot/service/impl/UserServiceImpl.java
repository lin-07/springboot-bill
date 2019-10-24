package com.lq.springboot.service.impl;

import com.lq.springboot.entities.User;
import com.lq.springboot.mapper.UserMapper;
import com.lq.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers(User user) {
        return userMapper.getUsers(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public User getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }
}
