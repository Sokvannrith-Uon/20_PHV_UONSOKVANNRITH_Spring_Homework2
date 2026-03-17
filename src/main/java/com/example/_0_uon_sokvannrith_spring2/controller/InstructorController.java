package com.example._0_uon_sokvannrith_spring2.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorController {
    private long instructorId;
    private String instructorName;
    private String email;
}
