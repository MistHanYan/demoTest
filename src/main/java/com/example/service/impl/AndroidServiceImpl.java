package com.example.service.impl;

import com.example.entity.User;
import com.example.service.AndroidService;
import com.example.util.mybatis.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Service
public class AndroidServiceImpl implements AndroidService {
    @Resource
    private UserMapper userMapper;

    private static final Logger logger = LogManager.getLogger(AndroidService.class);
    @Override
    public List<User> getUser() {
        return userMapper.userList();
    }

    @Override
    public int deleteUserById(int id , String passwd) {
        if(BCrypt.checkpw(passwd,userMapper.getPasswdById(id))){
            logger.info("Delete to user of id:{}",id);
            return userMapper.deleteUserById(id);
        }else {
            return 0;
        }
    }

    @Override
    public int updatePasswdOfUser(int id, String passwd) {
        if(BCrypt.checkpw(passwd,userMapper.getPasswdById(id))){
            logger.info("Delete to user of id:{}",id);
            return userMapper.updatePassWdById(id,pa);
        }else {
            return 0;
        }
    }

    @Override
    public void SignIn(String name, String passwd) {

    }

    @Override
    public int updateNameOfUser(int id, String name) {
        return 0;
    }

    @Override
    public User logIn(String name, String passwd) {
        return null;
    }
}
