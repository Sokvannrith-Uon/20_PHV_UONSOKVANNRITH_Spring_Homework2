package com.example._0_uon_sokvannrith_spring2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentRequest {
    private String name;
    private String email;
    private long phoneNumber;
}
