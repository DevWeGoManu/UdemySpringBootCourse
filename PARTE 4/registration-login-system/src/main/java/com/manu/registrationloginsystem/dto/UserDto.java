package com.manu.registrationloginsystem.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    @NotEmpty(message = "name required")
    private String firstName;
    @NotEmpty(message = "lastname required")
    private String lastName;
    @Email
    @NotEmpty(message = "email required")
    private String email;
    @NotEmpty(message = "Password required")
    private String password;

}
