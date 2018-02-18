package com.s305089.software.service;

import com.s305089.software.model.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    User findByUsername(String username);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserByUsername(String username);

    List<User> findAllUsers();

    boolean isUsernameUnique(Integer id, String username);
}
