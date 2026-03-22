package com.example._0_uon_sokvannrith_spring2.repository;

import com.example._0_uon_sokvannrith_spring2.model.entiity.Course;
import com.example._0_uon_sokvannrith_spring2.model.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Results(id = "courseMapping", value = {
            @Result(property = "courseId",column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "instructor",column = "instructor_id",
            one = @One(select = "com.example._0_uon_sokvannrith_spring2.repository.InstructorRepository.getInstructorById"))

    })
    @Select("""
            select * from courses 
            """)
    List<Course> getAllCourse();
    @ResultMap("courseMapping")
    @Select(
            """
                 select * from courses where course_id=#{courseId} 
            """
    )
    Course getCourseById(Long courseId);
    @ResultMap("courseMapping")
    @Select("""
            update courses set course_name=#{request.courseName},
            description=#{request.description} where course_id=#{courseId} returning *
            """)
    Course updateById(Long courseId, CourseRequest request);
    @ResultMap("courseMapping")
    @Select("""
            INSERT INTO courses (default,course_name, description, instructor_id)
            VALUES (#{request.courseName}, #{request.description}, #{request.instructor})
            RETURNING *
            """)
    Course createCourse(CourseRequest request);
    @ResultMap("courseMapping")
    @Select("""
                DELETE FROM courses WHERE course_id = #{courseId} RETURNING *
            """)
    Course deleteCourseById(Long courseId);
}
