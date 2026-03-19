package com.example._0_uon_sokvannrith_spring2.service;

import com.example._0_uon_sokvannrith_spring2.model.entiity.Instructor;
import com.example._0_uon_sokvannrith_spring2.model.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors();

    Instructor getInstructorById(Long instructorId);

    List<Instructor> saveInstructor(InstructorRequest request);

    Instructor deleteInstructorById(Long instructorId);

    Instructor updateInstructorById(Long instructorId,InstructorRequest request);
}
