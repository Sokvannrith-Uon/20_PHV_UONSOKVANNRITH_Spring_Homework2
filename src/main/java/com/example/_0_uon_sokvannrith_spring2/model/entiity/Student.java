package com.example._0_uon_sokvannrith_spring2.model.entiity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{
    private long studentId;
    private String name;
    private String email;
    private long phoneNumber;
}
