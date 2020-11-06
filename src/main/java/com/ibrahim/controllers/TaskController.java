package com.ibrahim.controllers;


import com.ibrahim.dto.TaskDto;
import com.ibrahim.entities.Task;
import com.ibrahim.service.TaskService;

import com.ibrahim.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/todolist/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService){
        this.taskService=taskService;
        this.userService = userService;
    }

    @PostMapping("/{userId}/createTask")
    public ResponseEntity<Void> createTask(@PathVariable String userId, @RequestBody TaskDto taskDto){
        taskDto.setUserId(userId);
        taskService.createTask(taskDto);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<Task>> listTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }
}

