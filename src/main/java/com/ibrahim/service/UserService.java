package com.ibrahim.service;

import com.ibrahim.dto.TaskDto;
import com.ibrahim.dto.UserDto;
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

    public List<UserDto> findAllUsers() {
        return userRepository.findAllUsers();
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
}
