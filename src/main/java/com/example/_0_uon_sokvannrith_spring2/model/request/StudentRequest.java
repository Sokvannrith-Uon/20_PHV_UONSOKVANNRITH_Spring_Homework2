package com.example._0_uon_sokvannrith_spring2.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String studentName;
    @Schema(example = "example@gmail.com")
    private String email;
    private String phoneNumber;
    private List<Long> courseId;



}
