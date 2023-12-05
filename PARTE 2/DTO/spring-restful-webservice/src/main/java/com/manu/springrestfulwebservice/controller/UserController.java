package com.manu.springrestfulwebservice.controller;

import com.manu.springrestfulwebservice.dto.UserDto;
import com.manu.springrestfulwebservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController()
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user)
    {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long userId)
    {
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        List<UserDto> user = userService.getAllUsers();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @PutMapping("/users/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@RequestBody UserDto user)
    {
        user.setId(userId);
        UserDto  userUpdate= userService.updateUser( user);
        return new ResponseEntity<>(userUpdate ,HttpStatus.OK);

    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId )
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User  has been deleted", HttpStatus.OK);
    }
}
