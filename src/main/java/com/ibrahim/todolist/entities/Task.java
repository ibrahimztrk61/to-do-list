package com.ibrahim.todolist.entities;

import java.util.UUID;

public class Task {

    private String id;
    private String category;
    private String description;
    private Enum status;
    private String duration;

    public Task(String category, String description, Enum status, String duration) {
        this.id = UUID.randomUUID().toString();
        this.category = category;
        this.description = description;
        this.status = status;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
