package com.ibrahim.controllers;


import com.ibrahim.entities.Task;
import com.ibrahim.service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping
    public ResponseEntity<Void> createTask(@RequestBody Task task){
        taskService.createTask(task);
        return ResponseEntity.ok().build();

    }
}

