package com.ibrahim.todolist.service;

import com.ibrahim.todolist.entities.Task;
import com.ibrahim.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }
}
