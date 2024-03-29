package com.s305089.software.dao;

import com.s305089.software.model.User;

import java.util.List;

public interface UserDao {
    User findById(int id);

    User findByUsername(String username);

    void save(User user);

    void deleteByUsername(String username);

    List<User> findAllUsers();
}
