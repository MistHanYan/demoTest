package com.example.service.impl.tools;

import com.example.entity.Account;
import com.example.entity.ElectiveInformation;
import com.example.service.impl.UserServiceForDelete;
import com.example.util.tools.EncryptionUtils;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeleteToData extends UserServiceForDelete {
    @Resource
    private EncryptionUtils encryptionUtils;

    private static final Logger logger = LoggerFactory.getLogger(DeleteToData.class);

    public int deleteAccount(Account account) throws Exception {
        if(encryptionUtils.checkPasswd(account.getNewPasswd(),
                super.getAccount(account).getPasswd())){
            logger.debug("Passwd to check successful for user");
            if(super.deletedToAccount(account.getStudent_num()) > 0) {
                logger.debug("delete account that will to delete detailed for user");
                return deleteDetailed(account);
            }else {
                return 0;
            }
        }else {
            return -1;
        }
    }

    public int deleteDetailed(Account account){
        return super.deleteToDetailed(account.getStudent_num());
    }

    public int deleteElective(ElectiveInformation electiveInformation){
        return super.deletedToElectiveInformation(
                electiveInformation.getStudent_num(), electiveInformation.getElective_id());
    }
}
