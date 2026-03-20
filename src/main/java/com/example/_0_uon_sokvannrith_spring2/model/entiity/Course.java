package com.example._0_uon_sokvannrith_spring2.model.entiity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private long courseId;
    private String courseName;
    private String description;
    private Instructor instructor;
}
