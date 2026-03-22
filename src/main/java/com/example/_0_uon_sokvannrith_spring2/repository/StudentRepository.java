package com.example._0_uon_sokvannrith_spring2.repository;

import com.example._0_uon_sokvannrith_spring2.model.entiity.Student;
import com.example._0_uon_sokvannrith_spring2.model.request.InstructorRequest;
import com.example._0_uon_sokvannrith_spring2.model.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface StudentRepository {
    @Results(id="studentMapping",value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property ="courses",column ="student_id",many =
            @Many(select = "com.example._0_uon_sokvannrith_spring2.repository.CourseRepository.getCourseById")
            )
    })
    @Select("""
       SELECT  * FROM students offset #{offset} LIMIT #{size}
    """)
    List<Student> getAllStudents(@Param("offset") Integer offset, @Param("size") Integer size);
    @ResultMap("studentMapping")
    @Select("""
            SELECT * FROM students WHERE student_id = #{studentId}
            """)
    Student getStudentById(Long studentId);
    @ResultMap("studentMapping")
    @Insert("""
                INSERT INTO student_course (student_id, course_id)
                VALUES (#{studentId}, #{courseId})
            """)

    List<Student> createStudent(@Param("studentId") Long studentId,
    @Param("courseId") Long courseId);

    @ResultMap("studentMapping")
    @Select("""
                UPDATE students
                SET student_name = #{req.studentName}, email = #{req.email}, phone_number = #{req.phoneNumber}
                WHERE student_id = #{studentId} RETURNING *
            """)
    Student updateStudentById(Long studentId,@Param("req" )StudentRequest request);
    @ResultMap("studentMapping")
    @Select("""
                DELETE FROM students WHERE student_id = #{studentId} RETURNING *
            """)
    Student deleteStudentById(Long studentId);
    void insertStudentCourse(Long studentId, Long courseId);

}
