package com.example.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class Schedule {

    private Integer id;
    @NotBlank
    private String title;
    @NotNull
    private Boolean completed;

    private Integer completed1;

    private Integer completed2;
}
