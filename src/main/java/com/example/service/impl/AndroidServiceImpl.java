package com.example.service.impl;

import com.example.entity.User;
import com.example.service.AndroidService;
import com.example.token.GetByJWT;
import com.example.util.config.EncryptionUtils;
import com.example.util.mybatis.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
@Service
public class AndroidServiceImpl implements AndroidService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private GetByJWT getByJWT;

    @Resource
    private EncryptionUtils encryptionUtils;

    private static final Logger logger = LogManager.getLogger(AndroidService.class);
    @Override
    public List<User> getUser() {
        return userMapper.userList();
    }

    @Override
    public int deleteUserById(int id, User user) throws Exception {
        if(encryptionUtils.checkPasswd(
                user.getInput_passwd(),
                userMapper.getUserById(user.getId()).getPass_wd())){
            logger.info("Delete to user of id:{}",user.getId());
            return userMapper.deleteUserById(id);
        }else {
            return -1;
        }
    }

    @Override
    public int updatePasswdOfUser(User user, String inputPasswd) throws Exception {
        if(encryptionUtils.checkPasswd(
                user.getPass_wd(),
                userMapper.getUserById(user.getId()).getPass_wd())){
            logger.info("Delete to user of id:{}",user.getId());
            return userMapper.updatePassWdById(user.getId(),
                    encryptionUtils.encrypt(inputPasswd));
        }else {
            return -1;
        }
    }

    @Override
    public int SignIn(User user) throws Exception {
        return userMapper.getUserByName(user.getUser_name()) == null
        ? userMapper.insertUser(
                user.getUser_name(), encryptionUtils.encrypt(user.getPass_wd()))
        : -1;
    }

    @Override
    public int updateNameOfUser(int id , String newName) {
        return userMapper.updateNameById(newName,id);
    }

    @Override
    public boolean logIn(User user) throws Exception {
        if(encryptionUtils.checkPasswd(user.getPass_wd(),
                userMapper.getUserByName(user.getUser_name())
                        .getPass_wd())){
            HashMap<String, Object> userToJwt = new HashMap<>();
            userToJwt.put("id",user.getId());
            userToJwt.put("user_name",user.getUser_name());
            user.setJwt(getByJWT.generateToken(userToJwt));
            return true;
        }return false;
    }

    @Override
    public User getUserById(User user) {
        return userMapper.getUserById(user.getId());
    }
}
