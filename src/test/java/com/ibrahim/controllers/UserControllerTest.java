package com.ibrahim.controllers;

import com.ibrahim.dtos.UserDto;
import com.ibrahim.entities.User;
import com.ibrahim.service.UserService;
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
    public void it_should_create_user() {
        // Given
        UserDto userDto = new UserDto();
        userDto.setName("ibrahim");
        userDto.setSurname("öztürk");

        // When
        userController.createUser(userDto);

        var userDtoArgumentCaptor = ArgumentCaptor.forClass(UserDto.class);
        verify(userService).createUser(userDtoArgumentCaptor.capture());
        var capturedUserRequest = userDtoArgumentCaptor.getValue();

        // Then
        assertThat(capturedUserRequest).isEqualToComparingFieldByField(userDto);

    }

    @Test
    public void it_should_get_all_users() {
        // Given

        // When
        userController.getAllUsers();

        // Then
        verify(userService).getAllUsers();

    }

    @Test
    void it_should_get_user_by_id() {
        // Given
        String id = "id";
        UserDto userDto = new UserDto();
        userDto.setId(id);

        when(userService.findUserById(id)).thenReturn(userDto);
        // When
        UserDto controllerUser = userController.findUserById(userDto.getId());
        // Then
        verify(userService).findUserById("id");
        assertThat(userDto).isEqualTo(controllerUser);
    }


    @Test
    void it_should_delete_user() {
        // Given
        String id = "id";

        // When
        userController.deleteUser(id);

        // Then
        verify(userService).deleteUser(id);
    }

}