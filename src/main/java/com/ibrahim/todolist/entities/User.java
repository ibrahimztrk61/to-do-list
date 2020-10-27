package com.ibrahim.todolist.entities;

import java.util.List;


public class User {

    private String id;
    private String name;
    private List<Task> tasks;


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
