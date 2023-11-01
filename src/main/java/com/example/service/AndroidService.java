package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface AndroidService {
    List<User> getUser();

    int deleteUserById(int id, User user) throws Exception;

    int updatePasswdOfUser(User user,String inputPasswd) throws Exception;

    int SignIn(User user) throws Exception;

    int updateNameOfUser(int id , String newName);

    boolean logIn(User user) throws Exception;

    User getUserById(User user);
}
