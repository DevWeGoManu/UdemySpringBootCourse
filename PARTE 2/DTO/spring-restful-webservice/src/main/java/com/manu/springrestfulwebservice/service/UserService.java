package com.manu.springrestfulwebservice.service;

import com.manu.springrestfulwebservice.dto.UserDto;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);

    void deleteUser(Long id);

}
