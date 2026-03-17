package com.example._0_uon_sokvannrith_spring2.controller;


import com.example._0_uon_sokvannrith_spring2.model.entiity.Instructor;
import com.example._0_uon_sokvannrith_spring2.service.InstructorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping
    public List<Instructor> getAllInstructors(){

        return instructorService.getAllInstructors();
    }

}
