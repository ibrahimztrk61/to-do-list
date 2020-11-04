package com.ibrahim.entities;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class User {

    private String id;
    private String name;
    private List<Task> tasks;

    public User( String name) {
        this.id = UUID.randomUUID().toString() ;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
