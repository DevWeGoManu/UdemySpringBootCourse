package com.manu.thymeleaftutorial.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserForm {
    private String name;
    private String email;
    private String password;
    private String gender;
    private String address;
    private boolean married;
    private String profession;
}
