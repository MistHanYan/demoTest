package com.example.service.impl.tools;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.entity.ElectiveInformation;
import com.example.service.impl.UserServiceForShow;
import com.example.util.tools.EncryptionUtils;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowToData extends UserServiceForShow {

   @Resource
   private EncryptionUtils encryptionUtils;

   private static final Logger logger = LoggerFactory.getLogger(ShowToData.class);

   public Account checkAccountByAccount(Account account) throws Exception {
      Account outAccount = super.getAccountByAccount(account);
      return encryptionUtils.checkPasswd(account.getPasswd(),
              outAccount.getPasswd()) ? outAccount : null;
   }

   public Account checkAccountByStudentNum(Account account) throws Exception {
      Account outAccount = super.getAccountByStudentNum(account);
      if(encryptionUtils.checkPasswd(account.getPasswd(),
              outAccount.getPasswd())){
         outAccount.setPasswd("");
         return outAccount;
      }else {
         return null;
      }
   }

   public Account checkAccountByEmail(Account account) throws Exception {
      Account outAccount = super.getAccountByEmail(account);
      return encryptionUtils.checkPasswd(account.getPasswd(),
              outAccount.getPasswd()) ? outAccount : null;
   }

   public Account checkAccountByPhoneNum(Account account) throws Exception {
      Account outAccount = super.getAccountByPhoneNum(account);
      logger.debug("account in sql: {}",account);
      return encryptionUtils.checkPasswd(account.getPasswd(),
              outAccount.getPasswd()) ? outAccount : null;
   }

   public List<ElectiveInformation> getElectiveData(Account account){
      return super.getElectiveInformationByStudentNum(account);
   }

   public Detailed getDetailedData(Account account){
      return super.getDetailedByStudentNum(account);
   }
}
