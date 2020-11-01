package com.ibrahim.controllers;


import com.ibrahim.dto.TaskDto;
import com.ibrahim.entities.Task;
import com.ibrahim.service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskDto taskDto){
        taskService.createTask(taskDto);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<Task>> listTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }
}

