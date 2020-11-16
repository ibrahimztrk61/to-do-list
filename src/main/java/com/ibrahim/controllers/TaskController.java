package com.ibrahim.controllers;


import com.ibrahim.dtos.TaskDto;
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

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> listTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }
}

