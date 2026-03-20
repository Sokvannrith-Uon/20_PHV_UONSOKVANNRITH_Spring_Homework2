package com.example._0_uon_sokvannrith_spring2.repository;
import com.example._0_uon_sokvannrith_spring2.model.entiity.Instructor;
import com.example._0_uon_sokvannrith_spring2.model.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {
    @Results(id = "instructorMapping", value = {@Result(property = "instructorName", column = "instructor_name")
          })

    @Select("""
               SELECT  * FROM instructors
            """)
    List<Instructor> getAllInstructors();

    @ResultMap({"instructorMapping"})
    @Select("""
            select * from instructors where instructor_id=#{instructorId};
            """)
    Instructor getInstructorById(Long instructorId);

    @ResultMap({"instructorMapping"})
    @Select("""
            insert into instructors values (default,#{req.instructorName},#{req.email}) returning *;
            """)
    List<Instructor> saveInstructor(@Param("req") InstructorRequest request);

    @ResultMap({"instructorMapping"})
    @Select("""
                delete from instructors where instructor_id=#{instructorId} returning *;
            """)
    Instructor deleteInstructorById(Long instructorId);

    @ResultMap({"instructorMapping"})
    @Select("""
                update instructors 
                set instructor_name=#{request.instructorName},email=#{request.email}
                where instructor_id=#{instructorId}
                returning *;
            """)
    Instructor updateInstructorById(Long instructorId, InstructorRequest request);

}
