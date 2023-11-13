package com.example.service.impl;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.service.Update;
import com.example.util.mybatis.UpdateData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public abstract class UserServiceForUpdate implements Update {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceForUpdate.class);

    @Autowired
    private UpdateData updateData;
    @Override
    public int updateDetailed(Detailed detailed) {
        return updateData.updateDetailed(detailed);
    }

    @Override
    public int updateAccount(Account account) {
        try {
            return updateData.updateAccount(account);
        }catch (Exception e){
            if (e.getCause() instanceof SQLException sqlException) {
                logger.debug("The data had like");
                return sqlException.getSQLState().startsWith("23")?-1:0;
            }
        }
        return 0;
    }

    protected int updatePasswd(String passwd , String student_num){
        return updateData.updatePasswd(passwd,student_num);
    }
}
