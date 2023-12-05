package com.manu.todomanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDto {
    private Long Id;
    private String title;
    private String description;
    private boolean isCompleted;
}
