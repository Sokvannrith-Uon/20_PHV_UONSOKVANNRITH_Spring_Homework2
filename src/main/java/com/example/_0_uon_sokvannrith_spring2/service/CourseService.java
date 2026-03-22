package com.example._0_uon_sokvannrith_spring2.service;

import com.example._0_uon_sokvannrith_spring2.model.entiity.Course;
import com.example._0_uon_sokvannrith_spring2.model.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();

    Course getCourseById(Long courseId);

    Course updateById(Long courseId, CourseRequest request);

    Course createCourse(CourseRequest request);

    Course deleteCourseById(Long courseId);
}
