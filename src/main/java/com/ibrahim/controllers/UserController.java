package com.ibrahim.controllers;

import com.ibrahim.dtos.TaskDto;
import com.ibrahim.dtos.UserDto;
import com.ibrahim.entities.TaskStatus;
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

    public UserController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserByName/{userName}")
    public List<UserDto> getUserByName(@PathVariable String userName) {
        return userService.getUserByName(userName);
    }

    @GetMapping("/findUserById/{userId}")
    public UserDto findUserById(@PathVariable String userId){
        return userService.findUserById(userId);
    }

    @DeleteMapping("/{userId}/deleteUser")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/createTask")
    public ResponseEntity<Void> createTask(@PathVariable String userId, @RequestBody TaskDto taskDto) {
        taskDto.setUserId(userId);
        userService.createTask(taskDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{taskId}/changeTask")
    public ResponseEntity<Void> changeTaskStatus(@PathVariable String taskId, @RequestBody TaskStatus taskStatus) {
        userService.changeTaskStatus(taskId, taskStatus);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/taskUpdate/{taskId}")
    public ResponseEntity<Void> updateTask(@RequestBody TaskDto taskDto) {
        userService.updateTask(taskDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{taskId}/deleteTask")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskId) {
        userService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }
}

