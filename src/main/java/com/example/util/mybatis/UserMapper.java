package com.example.util.mybatis;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {

    // This is a test to contra of mybatis
    @Select("select * from study_test")
    List<User> userList();

    @Select("SELECT * FROM study_test WHERE user_name = #{user_name}")
    User getUserByName(String user_name);

    // Seek passwd by id of user
    @Select("SELECT * FROM study_test WHERE id = #{id}")
    User getUserById(int id);

    // Delete user by id
    @Delete("delete from study_test where id = #{id}")
    int deleteUserById(int id);

    // Update name by id
    @Update("UPDATE study_test SET user_name = #{user_name} WHERE id = #{id}")
    int updateNameById(String user_name,int id);

    // Update passwd by id
    @Update("UPDATE study_test SET pass_wd = #{pass_wd} WHERE id = #{id}")
    int updatePassWdById(int id, String pass_wd);

    // Insert into user
    @Insert("INSERT INTO study_test (user_name,pass_wd) values (#{user_name},#{pass_wd})")
    int insertUser(String user_name, String pass_wd);
}
