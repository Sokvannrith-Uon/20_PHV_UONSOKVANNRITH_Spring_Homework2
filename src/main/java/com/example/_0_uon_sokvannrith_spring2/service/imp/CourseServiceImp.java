package com.example._0_uon_sokvannrith_spring2.service.imp;

import com.example._0_uon_sokvannrith_spring2.model.entiity.Course;
import com.example._0_uon_sokvannrith_spring2.model.request.CourseRequest;
import com.example._0_uon_sokvannrith_spring2.repository.CourseRepository;
import com.example._0_uon_sokvannrith_spring2.repository.InstructorRepository;
import com.example._0_uon_sokvannrith_spring2.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Course updateById(Long courseId, CourseRequest request) {
        return courseRepository.updateById(courseId,request);
    }

    @Override
    public Course createCourse(CourseRequest request) {
        return courseRepository.createCourse(request);
    }

    @Override
    public Course deleteCourseById(Long courseId) {
        return courseRepository.deleteCourseById(courseId);
    }
}
