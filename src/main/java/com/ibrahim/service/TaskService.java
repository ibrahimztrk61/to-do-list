package com.ibrahim.service;

import com.ibrahim.dto.TaskDto;
import com.ibrahim.entities.Task;
import com.ibrahim.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(TaskDto taskDto) {
        taskRepository.save(taskDto);
    }

    public List<Task> findAll() {
        return taskRepository.findAllTasks();
    }
}
