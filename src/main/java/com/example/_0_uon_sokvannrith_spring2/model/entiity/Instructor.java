package com.example._0_uon_sokvannrith_spring2.model.entiity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    private long instructor_id;
    private String instructorName;
    @Schema(example = "example@gmail.com")
    private String email;
}
