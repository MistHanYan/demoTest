package com.example.service.impl;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.entity.ElectiveClass;
import com.example.entity.ElectiveInformation;
import com.example.service.Add;
import com.example.util.mybatis.InsertData;
import com.example.util.mybatis.SelectData;
import com.example.util.mybatis.UpdateData;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UserServiceForAdd implements Add {

    @Autowired
    private InsertData insertData;

    @Autowired
    private SelectData selectData;

    @Autowired
    private UpdateData updateData;

    @Override
    public int addAccount(Account account) {
        return insertData.addAccount(account);
    }

    @Override
    public int addElectiveToInformation(ElectiveInformation electiveInformation) {
        return insertData.addElectiveInformation(electiveInformation);
    }

    @Override
    public int addDetailed(Detailed detailed) {
        return insertData.addDetailed(detailed.getStudent_num());
    }

    protected boolean isEmptyElectiveInformation(String student_num , String elective_id){
        return selectData.IsEmptyElectiveInformation(student_num, elective_id) == null;
    }

    public boolean isEmptyAccount(String account){
        return selectData.getAccountByAccount(account) != null;
    }
    public boolean isEmptyStudentNum(String student_num) {
        return selectData.getAccountByStudentNum(student_num) == null;
    }

    public boolean isEmptyPhoneNum(String phoneNum) {
        return selectData.getAccountByStudentNum(phoneNum) == null;
    }

    public boolean isEmptyEmail(String email) {
        return selectData.getAccountByStudentNum(email) == null;
    }

    public ElectiveClass getElectiveMsg(ElectiveClass electiveClass){
        return selectData.getSurplusForElective(electiveClass);
    }

    public int updateSurplus(ElectiveClass electiveClass){
        electiveClass.setSurplus(
                electiveClass.getSurplus()-1);
        return updateData.updateSurplus(electiveClass);
    }
}
