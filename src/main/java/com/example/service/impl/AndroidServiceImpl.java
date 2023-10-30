package com.example.service.impl;

import com.example.entity.User;
import com.example.service.AndroidService;
import com.example.token.GetByJWT;
import com.example.util.encrypt.GetEncryptPasswd;
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

    private static final Logger logger = LogManager.getLogger(AndroidService.class);
    @Override
    public List<User> getUser() {
        return userMapper.userList();
    }

    @Override
    public int deleteUserById(User user) {
        if(new GetEncryptPasswd().checkPasswd(
                user.getPass_wd(),
                userMapper.getUserById(user.getId()).getPass_wd())){
            logger.info("Delete to user of id:{}",user.getId());
            return userMapper.deleteUserById(user.getId());
        }else {
            return -1;
        }
    }

    @Override
    public int updatePasswdOfUser(User user) {
        if(new GetEncryptPasswd().checkPasswd(
                user.getPass_wd(),
                userMapper.getUserById(user.getId()).getPass_wd())){
            logger.info("Delete to user of id:{}",user.getId());
            return userMapper.updatePassWdById(user.getId(),
                    new GetEncryptPasswd().toEncrypt(user.getPass_wd()));
        }else {
            return -1;
        }
    }

    @Override
    public int SignIn(User user) {
        return userMapper.getUserByName(user.getUser_name()) == null
        ?userMapper.insertUser(
                user.getUser_name(),new GetEncryptPasswd().toEncrypt(user.getPass_wd()))
        :-1;
    }

    @Override
    public int updateNameOfUser(User user) {
        return userMapper.updateNameById(user.getId(),user.getUser_name());
    }

    @Override
    public String logIn(User user) {
        if(new GetEncryptPasswd()
                .checkPasswd(user.getPass_wd(),
                userMapper.getUserByName(user.getUser_name())
                        .getPass_wd())){
            HashMap<String, Object> userToJwt = new HashMap<>();
            userToJwt.put("id",user.getId());
            userToJwt.put("name",user.getUser_name());
            return new GetByJWT().generateToken(userToJwt);
        }return null;
    }

    @Override
    public User getUserById(User user) {
        return userMapper.getUserById(user.getId());
    }
}
