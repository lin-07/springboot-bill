package com.lq.springboot.mapper;

import com.lq.springboot.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUsers(User user);

    User getById(Integer id);

    void update(User user);

    void save(User user);

    void delete(Integer id);

    User getUserByUserName(String username);
}
