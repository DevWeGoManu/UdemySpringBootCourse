package com.manu.springbootwebfluxtutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
