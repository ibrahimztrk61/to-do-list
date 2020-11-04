package com.ibrahim.controllers;

import com.ibrahim.dto.UserDto;
import com.ibrahim.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;


    @Test
    void it_should_create_user() {
        // Given
        UserDto userRequest = new UserDto();
        userRequest.setName("ibrahim");

        // When
        userController.createUser(userRequest);

        // Then
        var userRequestArgumentCaptor = ArgumentCaptor.forClass(UserDto.class);
        verify(userService).createUser(userRequestArgumentCaptor.capture());
        var capturedUserRequest = userRequestArgumentCaptor.getValue();
        assertThat(capturedUserRequest).isEqualToComparingFieldByField(userRequest);

    }
}