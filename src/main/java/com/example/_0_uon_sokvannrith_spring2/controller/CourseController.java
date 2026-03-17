package com.example._0_uon_sokvannrith_spring2.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseController {
    private long courseId;
    private String courseName;
    private String description;
}
