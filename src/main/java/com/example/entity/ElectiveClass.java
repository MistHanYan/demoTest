package com.example.entity;

import lombok.Data;

@Data
public class ElectiveClass {
    private int id;
    private String elective_id;
    private String elective_name;
    private String elective_teacher;
    private boolean elective_state;
    private int surplus;
}
