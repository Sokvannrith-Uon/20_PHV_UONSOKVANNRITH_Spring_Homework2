package com.example._0_uon_sokvannrith_spring2.service.imp;


import com.example._0_uon_sokvannrith_spring2.model.entiity.Student;
import com.example._0_uon_sokvannrith_spring2.repository.StudentRepository;
import com.example._0_uon_sokvannrith_spring2.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    public final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
//    public List<StudentResponse> getAllStudents() {
//
//        List<StudentResponse> studentResponseList = studentRepository.getAllStudents().stream()
//                .map(s -> new StudentResponse(s.getStudentId(),s.getName(),s.getEmail())).toList();
//
//        return studentResponseList;
//    }
    public List<Student> getAllStudents(){
        return  studentRepository.getAllStudents();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }
}
