package com.example._0_uon_sokvannrith_spring2.controller;


import com.example._0_uon_sokvannrith_spring2.model.entiity.Instructor;
import com.example._0_uon_sokvannrith_spring2.model.request.InstructorRequest;
import com.example._0_uon_sokvannrith_spring2.model.respoonse.ResponseApi;
import com.example._0_uon_sokvannrith_spring2.service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructor")

public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    @Operation(summary = "get all instructor")
    public ResponseEntity<ResponseApi<List<Instructor>>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        ResponseApi<List<Instructor>> response = ResponseApi.<List<Instructor>>builder().success(true).status(HttpStatus.OK).message("Instructors fetched successfully").payload(instructors).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{instructor-id}")
    @Operation(summary = "get instructor by id")
    public ResponseEntity<ResponseApi<Instructor>> getInstructorById(@PathVariable("instructor-id") Long instructorId) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        if (instructor == null) {
            ResponseApi<Instructor> responseApi = ResponseApi.<Instructor>builder().success(false).status(HttpStatus.NOT_FOUND).message("Don't has data ").payload(instructor).timestamp(Instant.now()).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseApi);

        }
        ResponseApi<Instructor> responseApi = ResponseApi.<Instructor>builder().success(true).status(HttpStatus.OK).message("SuccessFully").payload(instructor).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }

    @PostMapping
    @Operation(summary = "create instructor")
    public ResponseEntity<ResponseApi<List<Instructor>>> saveInstructor(@RequestBody InstructorRequest request) {
        List<Instructor> instructors = instructorService.saveInstructor(request);
        ResponseApi<List<Instructor>> createResponse = ResponseApi.<List<Instructor>>builder().success(true).status(HttpStatus.OK).message("Instructors created successfully").payload(instructors).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(createResponse);
    }

    @DeleteMapping("{instructor-id}")
    @Operation(summary = "delete instructor by id")
    public ResponseEntity<ResponseApi<Instructor>> DeleteInstructorById(@PathVariable("instructor-id") Long instructorId) {
        Instructor delInstructor = instructorService.deleteInstructorById(instructorId);
        if (delInstructor == null) {
            ResponseApi<Instructor> responseApi = ResponseApi.<Instructor>builder().success(false).status(HttpStatus.NOT_FOUND).message("Don't has data ").payload(delInstructor).timestamp(Instant.now()).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseApi);

        }
        ResponseApi<Instructor> responseApi = ResponseApi.<Instructor>builder().success(true).status(HttpStatus.OK).message("SuccessFully").payload(delInstructor).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }

    @PutMapping("{update-id}")
    public ResponseEntity<ResponseApi<Instructor>> updateInstructorById(@PathVariable("update-id") Long instructorId, @RequestBody InstructorRequest request) {
        Instructor updateInstructor = instructorService.updateInstructorById(instructorId, request);
        if (updateInstructor == null) {
            ResponseApi<Instructor> updateRes = ResponseApi.<Instructor>builder().success(false).status(HttpStatus.NOT_FOUND).message("doesn't has date for delete").timestamp(Instant.now()).payload(updateInstructor).build();
            return ResponseEntity.ok(updateRes);
        }
        ResponseApi<Instructor> updateRes = ResponseApi.<Instructor>builder().success(true).status(HttpStatus.OK).message("can").payload(updateInstructor).timestamp(Instant.now()).build();
        return ResponseEntity.ok(updateRes);

    }
}
