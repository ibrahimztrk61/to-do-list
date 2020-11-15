package com.ibrahim.service;

import com.ibrahim.dtos.TaskDto;
import com.ibrahim.dtos.UpdateTaskDto;
import com.ibrahim.dtos.UserDto;
import com.ibrahim.entities.TaskStatus;
import com.ibrahim.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDto userDto) {
        userRepository.saveUser(userDto);

    }
    public UserDto findUserById(String userId){
       return userRepository.findUserById(userId);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void createTask(TaskDto taskDto) {
        userRepository.createTask(taskDto);
    }

    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }

    public void deleteTask(String taskId) {
        userRepository.deleteTask(taskId);
    }

    public void changeTaskStatus(String taskId, TaskStatus taskStatus) {
        userRepository.changeTaskStatus(taskId, taskStatus);
    }

    public List<UserDto> getUserByName(String userName) {
        return userRepository.getUserByName(userName);
    }

    public void updateTask(String taskId, UpdateTaskDto taskDto) {
        userRepository.updateTask(taskId,taskDto);
    }
}
