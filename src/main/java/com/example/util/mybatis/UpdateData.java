package com.example.util.mybatis;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.entity.ElectiveClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UpdateData {
    @Update("UPDATE account_information SET " +
            "nickname = #{nickname}, email = #{email}, phone_num = #{phone_num} " +
            "WHERE student_num = #{student_num}")
    int updateAccount(Account account);

    @Update("UPDATE detailed_information SET institution = #{institution} , major = #{major} , grade = #{grade} , " +
            "institution = #{institution} ,gender = #{gender} , class_num = #{class_num} , city = #{city} , " +
            "nationality = #{nationality} , name = #{name} WHERE student_num = #{student_num}")
    int updateDetailed(Detailed detailed);

    @Update("UPDATE account_information SET " +
            "passwd = #{passwd} " +
            "WHERE student_num = #{student_num}")
    int updatePasswd(String passwd , String student_num);

    @Update("UPDATE elective_class SET surplus = #{surplus} WHERE elective_id = #{elective_id}")
    int updateSurplus(ElectiveClass electiveClass);
}
