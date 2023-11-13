package com.example.service.impl.tools;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.service.impl.UserServiceForShow;
import com.example.service.impl.UserServiceForUpdate;
import com.example.util.tools.EncryptionUtils;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UpdateToData extends UserServiceForUpdate {

    @Resource
    private EncryptionUtils encryptionUtils;

    @Resource
    private UserServiceForShow userServiceForShow;

    private static final Logger logger = LoggerFactory.getLogger(UpdateToData.class);
    public int updateAccountData(Account account){
        return super.updateAccount(account);
    }

    public int updateDetailedData(Detailed detailed){
        return super.updateDetailed(detailed);
    }

    public int updateUserPassWd(Account account) throws Exception {
        logger.debug("account msg:{}",account);
        return checkAccountByAccount(account)
                ? super.updatePasswd(encryptionUtils.encrypt(account.getNewPasswd()), account.getStudent_num())
                : 0;
    }

    public boolean checkAccountByAccount(Account account) throws Exception {
        return encryptionUtils.checkPasswd(account.getPasswd(),
                userServiceForShow.getAccountByAccount(account).getPasswd());
    }
}
