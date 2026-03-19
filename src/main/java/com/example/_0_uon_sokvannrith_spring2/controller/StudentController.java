package com.example._0_uon_sokvannrith_spring2.controller;

import com.example._0_uon_sokvannrith_spring2.model.dto.StudentRequest;
import com.example._0_uon_sokvannrith_spring2.model.entiity.Student;
import com.example._0_uon_sokvannrith_spring2.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@Tag(name = "StudentController")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @Operation(summary = "get student by id")
    @GetMapping("/{student-id}")
    public Student getStudentById(@PathVariable("student-id") long studentId){


        return studentService.getStudentById(studentId);
    }
    @PostMapping
    public Student createStudent(@RequestBody StudentRequest studentRequest){
        return new Student();
    }
    @PutMapping("/{student-id}")
    @Operation(summary = "update student by id")
    public Student updateStudentById(){
      return null;
    }
}
