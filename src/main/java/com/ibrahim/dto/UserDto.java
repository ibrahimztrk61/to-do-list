package com.ibrahim.dto;

import com.ibrahim.entities.Task;
import com.ibrahim.entities.TaskStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class UserDto {

    private String id;
    private String name;
    private List<Task> tasks;

    public UserDto() {
        this.id = UUID.randomUUID().toString() ;
        this.tasks = Arrays.asList((new Task(id,"","", TaskStatus.TODO,"")));
    }

    public UserDto(String name) {
        this.id = UUID.randomUUID().toString() ;
        this.name = name;
        this.tasks = Arrays.asList((new Task(id,"","", TaskStatus.TODO,"")));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
