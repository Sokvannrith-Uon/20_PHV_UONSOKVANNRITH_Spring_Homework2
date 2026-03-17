package com.example._0_uon_sokvannrith_spring2.repository;

import com.example._0_uon_sokvannrith_spring2.model.entiity.Instructor;
import com.example._0_uon_sokvannrith_spring2.model.entiity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface InstructorRepository {
    @Result(property = "instructorName", column = "instructor_name")
    @Select("""
       SELECT  * FROM instructors
    """)
    List<Instructor> getAllInstructors();
}
