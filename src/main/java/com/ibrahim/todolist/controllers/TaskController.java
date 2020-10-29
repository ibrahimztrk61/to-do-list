package com.ibrahim.todolist.controllers;


import com.ibrahim.todolist.service.TaskService;
import com.ibrahim.todolist.entities.Task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody Task task){
        taskService.createTask(task);
        return ResponseEntity.ok().build();

    }
}

