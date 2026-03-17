package com.example._0_uon_sokvannrith_spring2.repository;

import com.example._0_uon_sokvannrith_spring2.model.entiity.Student;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface StudentRepository {
    @Result(property = "name", column = "student_name")
    @Select("""
      select  * from students
    """)
    List<Student> getAllStudents();

    Student getStudentById(Long studentId);
}
