package com.manu.springrestfulwebservice.mapper;

import com.manu.springrestfulwebservice.dto.UserDto;
import com.manu.springrestfulwebservice.model.User;

public class UserMapper {

    //Convert User Jpa Entity into UserDto
    public static UserDto mapToUserDto(User user)
    {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail()
        );
    }
    //Convert UserDto into User Jpa Entity
    public static User mapToUser(UserDto userDto)
    {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getUsername(),
                userDto.getEmail()
        );
    }
}
