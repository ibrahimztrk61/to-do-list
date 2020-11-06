package com.ibrahim.controllers;

import com.ibrahim.dto.TaskDto;
import com.ibrahim.dto.UserDto;
import com.ibrahim.entities.User;
import com.ibrahim.service.TaskService;
import com.ibrahim.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/todolist/users")
public class UserController {

    private final TaskService taskService;
    private final UserService userService;

    public UserController(TaskService taskService, UserService userService){
        this.taskService=taskService;
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

    @PostMapping("/{userId}/createTask")
    public ResponseEntity<Void> createTask(@PathVariable String userId, @RequestBody TaskDto taskDto){
        taskDto.setUserId(userId);
        userService.createTask(taskDto);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{userId}/deleteUser")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{taskId}/deleteTask")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskId){
        userService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }
}

