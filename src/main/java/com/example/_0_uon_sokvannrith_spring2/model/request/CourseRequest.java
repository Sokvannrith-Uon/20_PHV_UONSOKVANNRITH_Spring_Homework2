package com.example._0_uon_sokvannrith_spring2.model.request;

import com.example._0_uon_sokvannrith_spring2.model.entiity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CourseRequest {
    private final String courseName;
    private final String description;
    private final Instructor instructor;
}
