package com.ibrahim.dtos;

import com.ibrahim.entities.Task;
import com.ibrahim.entities.TaskStatus;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class UserDto {

    private String id;
    private String name;
    private String surname;
    private List<Task> tasks;

    public void setId(String id) {
        this.id = id;
    }

    public UserDto() {
        this.id = UUID.randomUUID().toString() ;
        this.tasks = Arrays.asList((new Task(id,"","", TaskStatus.TODO,"")));
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserDto(String name, String surname, Task task ) {
        this.id = UUID.randomUUID().toString() ;
        this.name = name;
        this.surname = surname;
        this.tasks = (List<Task>) task;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
