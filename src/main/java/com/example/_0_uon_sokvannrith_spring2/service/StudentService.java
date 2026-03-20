package com.example._0_uon_sokvannrith_spring2.service;


import com.example._0_uon_sokvannrith_spring2.model.entiity.Student;

import java.util.List;

public interface StudentService {


//    List<StudentResponse> getAllStudents();
List<Student> getAllStudents();
Student getStudentById(Long studentId);
}
