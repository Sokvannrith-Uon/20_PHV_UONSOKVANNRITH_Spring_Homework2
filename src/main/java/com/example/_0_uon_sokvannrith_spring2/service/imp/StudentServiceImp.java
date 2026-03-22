package com.example._0_uon_sokvannrith_spring2.service.imp;


import com.example._0_uon_sokvannrith_spring2.model.entiity.Student;
import com.example._0_uon_sokvannrith_spring2.model.request.StudentRequest;
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


//    public List<StudentResponse> getAllStudents() {
//
//        List<StudentResponse> studentResponseList = studentRepository.getAllStudents().stream()
//                .map(s -> new StudentResponse(s.getStudentId(),s.getName(),s.getEmail())).toList();
//
//        return studentResponseList;
//    }



    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents(Integer page, Integer size) {
        Integer offset = size * (page - 1);
        return studentRepository.getAllStudents(offset, size);
    }

    @Override
    public List<Student> createStudent(StudentRequest request) {
        return null;
    }


    @Override
    public Student updateStudentById(Long studentId, StudentRequest request) {
        return studentRepository.updateStudentById(studentId,request);
    }

    @Override
    public Student deleteStudentById(Long studentId) {
    return studentRepository.deleteStudentById(studentId);
    }
}
