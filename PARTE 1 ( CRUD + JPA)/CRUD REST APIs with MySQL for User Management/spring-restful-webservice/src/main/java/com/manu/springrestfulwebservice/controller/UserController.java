package com.manu.springrestfulwebservice.controller;

import com.manu.springrestfulwebservice.model.User;
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
    public ResponseEntity<User> createUser(@RequestBody  User user)
    {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long userId)
    {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> user = userService.getAllUsers();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @PutMapping("/users/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,@RequestBody User user)
    {
        user.setId(userId);
        User  userUpdate= userService.updateUser( user);
        return new ResponseEntity<>(userUpdate ,HttpStatus.OK);

    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId )
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User  has been deleted", HttpStatus.OK);
    }
}
