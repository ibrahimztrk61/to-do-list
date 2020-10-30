package com.ibrahim.controllers;

import com.ibrahim.dto.UserDto;
import com.ibrahim.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public ResponseEntity<Void> createUser(@PathVariable UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok().build();

    }

}
