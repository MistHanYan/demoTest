package com.example.service.impl.tools;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.entity.ElectiveClass;
import com.example.entity.ElectiveInformation;
import com.example.service.impl.UserServiceForAdd;
import com.example.util.tools.EncryptionUtils;
import com.example.util.tools.GetAccount;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AddToData extends UserServiceForAdd {

    @Resource
    private EncryptionUtils encryptionUtils;

    @Resource
    private GetAccount getAccount;

    private static final Logger logger = LoggerFactory.getLogger(AddToData.class);

    public int addAccountOfUser(Account account) throws Exception {
        String account_num = getAccount.generateRandomString();
        while(super.isEmptyAccount(account_num)){
            account_num = getAccount.generateRandomString();
        }
        account.setAccount(account_num);
        if(isEmptyStudentNum(account.getStudent_num())
                && isEmptyEmail(account.getEmail())
                && isEmptyPhoneNum(account.getPhone_num())){
            logger.debug("Don't had like the student num in database");
            Detailed detailed = new Detailed();
            detailed.setStudent_num(account.getStudent_num());
            account.setPasswd(encryptionUtils.encrypt(account.getPasswd()));
            if(super.addAccount(account) > 0){
                return super.addDetailed(detailed);
            }
            return 0;
        }
        return -1;
    }

    public int addElective(ElectiveClass electiveClass , String student_num){
        if(super.getElectiveMsg(electiveClass).getSurplus() > 0
                && super.getElectiveMsg(electiveClass).isElective_state()) {
            logger.debug("Surplus > 0 && state == true");
            if(super.isEmptyElectiveInformation(student_num,electiveClass.getElective_id())){
                if(super.addElectiveToInformation(getElectiveToAdd(electiveClass,student_num)) > 0){
                    logger.debug("Add elective is successful");
                    return updateSurplus(electiveClass) > 0 ? 1 : -1;
                }
                return 0;
            }
        }
        return 0;
    }

    private ElectiveInformation getElectiveToAdd(ElectiveClass electiveClass , String student_num){
        ElectiveInformation electiveInformation = new ElectiveInformation();
        electiveInformation.setElective_id(electiveClass.getElective_id());
        electiveInformation.setClass_name(electiveClass.getElective_name());
        electiveInformation.setStudent_num(student_num);
        return electiveInformation;
    }
}