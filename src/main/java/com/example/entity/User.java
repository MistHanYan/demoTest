package com.example.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String user_name;
    private String pass_wd;
    private String jwt;
    private String input_name;
    private String input_passwd;
}
