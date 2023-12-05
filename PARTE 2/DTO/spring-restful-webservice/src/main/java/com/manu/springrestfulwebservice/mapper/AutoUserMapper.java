package com.manu.springrestfulwebservice.mapper;

import com.manu.springrestfulwebservice.dto.UserDto;
import com.manu.springrestfulwebservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);

}
