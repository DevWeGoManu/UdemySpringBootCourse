package com.manu.registrationloginsystem.service;

import com.manu.registrationloginsystem.dto.UserDto;
import com.manu.registrationloginsystem.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserEmail(String email);

    List<UserDto> findAllUsers();
}
