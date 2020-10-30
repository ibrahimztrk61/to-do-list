package com.ibrahim.service;

import com.ibrahim.dto.UserDto;
import com.ibrahim.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDto userDto) {
        userRepository.saveUser(userDto);

    }
}