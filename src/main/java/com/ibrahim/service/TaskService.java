package com.ibrahim.service;

import com.ibrahim.entities.Task;
import com.ibrahim.repository.TaskRepository;
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
