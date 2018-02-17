package com.s305089.software.service;

import com.s305089.software.model.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    User findBySeries(String series);

    User findBySSO(String sso);

    User findByUsername(String username);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserBySSO(String sso);

    List<User> findAllUsers();

    boolean isUserSSOUnique(Integer id, String sso);
}
