package com.example.util.mybatis;

import com.example.entity.Account;
import com.example.entity.ElectiveInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsertData {
    @Insert("INSERT INTO account_information " +
            "(account, passwd, nickname, email, phone_num, student_num) " +
            "values (#{account},#{passwd},#{nickname},#{email},#{phone_num},#{student_num})")
    int addAccount(Account account);

    @Insert("INSERT INTO elective_information " +
            "(student_num, elective_id, class_name) " +
            "VALUES (#{student_num},#{elective_id},#{class_name})")
    int addElectiveInformation(ElectiveInformation electiveInformation);

    @Insert("INSERT INTO detailed_information " +
            "(student_num, institution, major, grade, instructor, gender, class_num, city, nationality, name) " +
            "VALUES (#{studentNum}, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, " +
            "DEFAULT, DEFAULT, DEFAULT, DEFAULT)")
    int addDetailed(String student_num);
}
