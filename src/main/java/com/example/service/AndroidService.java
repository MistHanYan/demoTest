package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface AndroidService {
    List<User> getUser();

    int deleteUserById(User user);

    int updatePasswdOfUser(User user);

    int SignIn(User user);

    int updateNameOfUser(User user);

    String logIn(User user);

    User getUserById(User user);
}
