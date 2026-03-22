package com.example._0_uon_sokvannrith_spring2.service;


import com.example._0_uon_sokvannrith_spring2.model.entiity.Student;
import com.example._0_uon_sokvannrith_spring2.model.request.StudentRequest;

import java.util.List;

public interface StudentService {




    Student getStudentById(Long studentId);

    List<Student> getAllStudents(Integer page, Integer size);

    List<Student> createStudent(StudentRequest studentRequest);

    Student updateStudentById(Long studentId, StudentRequest request);

   Student  deleteStudentById(Long studentId);
}
