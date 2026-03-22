package com.example._0_uon_sokvannrith_spring2.controller;


import com.example._0_uon_sokvannrith_spring2.model.entiity.Instructor;
import com.example._0_uon_sokvannrith_spring2.model.entiity.Student;
import com.example._0_uon_sokvannrith_spring2.model.request.StudentRequest;
import com.example._0_uon_sokvannrith_spring2.model.respoonse.ResponseApi;
import com.example._0_uon_sokvannrith_spring2.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@Tag(name = "StudentController")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }



    @Operation(summary = "get all student")
    @GetMapping
    public ResponseEntity<?> getAllStudent(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Student> students = studentService.getAllStudents(page, size);
        ResponseApi<List<Student>> responseApi = ResponseApi.<List<Student>>builder()
                .status(HttpStatus.OK).
                success(true).
                message("Get all students successfully").
                payload(students).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }

    @PostMapping
    public ResponseEntity<List<Student>> createStudent(@RequestBody StudentRequest studentRequest) {
        List<Student> student = studentService.createStudent(studentRequest);
        ResponseApi<List<Student>> createResponse = ResponseApi.<List<Student>>builder().success(true).status(HttpStatus.OK).message("Instructors created successfully").payload(student).timestamp(Instant.now()).build();
        return ResponseEntity.ok(createResponse.getPayload());

    }
    @Operation(summary = "Get student by id")
    @GetMapping("/{student-id}")
    public ResponseEntity<?> getStudentById(@PathVariable("student-id") Long studentId) {

        Student students = studentService.getStudentById(studentId);

        ResponseApi<Student> response = ResponseApi.<Student>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Student fetched successfully")
                .payload(students)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Update student by ID")
    @PutMapping("/{student-id}")
    public ResponseEntity<?> updateStudentById(@PathVariable("student-id") Long studentId, @RequestBody StudentRequest request) {

        Student students = studentService.updateStudentById(studentId, request);

        ResponseApi<Student> response = ResponseApi.<Student>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Student updated successfully")
                .payload(students)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Delete student by ID")
    @DeleteMapping("/{student-id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("student-id") Long studentId) {

        studentService.deleteStudentById(studentId);
        ResponseApi<String> response = ResponseApi.<String>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Student deleted successfully")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
