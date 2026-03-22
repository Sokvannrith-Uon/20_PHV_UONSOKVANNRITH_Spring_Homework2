package com.example._0_uon_sokvannrith_spring2.model.entiity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{
    private Long studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Course> courses;
}
