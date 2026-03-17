package com.example._0_uon_sokvannrith_spring2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private long studentId;
    private String name;
    private String email;
}
