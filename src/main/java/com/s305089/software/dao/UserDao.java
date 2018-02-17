package com.s305089.software.dao;

import com.s305089.software.model.User;

import java.util.List;

public interface UserDao {
    User findById(int id);

    User findBySeries(String series);

    User findBySSO(String sso);

    User findByUsername(String username);

    void save(User user);

    void deleteBySSO(String sso);

    List<User> findAllUsers();
}
