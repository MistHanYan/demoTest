package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface AndroidService {
    List<User> getUser();

    int deleteUserById(int id , String passwd);

    int updatePasswdOfUser(int id ,String passwd);

    void SignIn(String name ,String passwd);

    int updateNameOfUser(int id, String name);

    User logIn(String name, String passwd);
}
