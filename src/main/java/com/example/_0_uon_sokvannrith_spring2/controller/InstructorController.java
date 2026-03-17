package com.example._0_uon_sokvannrith_spring2.controller;


import com.example._0_uon_sokvannrith_spring2.service.InstructorService;

public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
}
