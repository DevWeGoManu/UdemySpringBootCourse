package com.manu.springrestfulwebservice.service;

import com.manu.springrestfulwebservice.dto.UserDto;
import com.manu.springrestfulwebservice.mapper.AutoUserMapper;
import com.manu.springrestfulwebservice.mapper.UserMapper;
import com.manu.springrestfulwebservice.model.User;
import com.manu.springrestfulwebservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto into User JPA Entity
        //User user = modelMapper.map(userDto,User.class);

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        //Conver User Jpa entity to UserDto
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElse(null);
        assert user != null;
        return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
    }

    @Override
    public List<UserDto> getAllUsers()
    {
        List<User> userList = userRepository.findAll();
        return userList.stream().map((AutoUserMapper.MAPPER::mapToUserDto))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User newUser = userRepository.findById(user.getId()).orElse(null);
        assert newUser != null;
        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(newUser);
 
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
