package com.ibrahim.controllers;

import com.ibrahim.dto.UserDto;
import com.ibrahim.entities.User;
import com.ibrahim.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok().build();

    }
    @GetMapping
    public List<UserDto> findAllUsers(){
       return userService.findAllUsers();

    }


}

