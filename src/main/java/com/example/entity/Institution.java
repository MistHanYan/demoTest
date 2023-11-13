package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institution {
    private int id;
    private String institution_id;
    private String institution_name;
    private String major_id;
    private String major_name;
}
