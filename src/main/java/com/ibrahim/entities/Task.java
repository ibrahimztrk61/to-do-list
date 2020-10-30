package com.ibrahim.entities;

import java.util.UUID;

public class Task {

    private String id;
    private String category;
    private String description;
    private TaskStatus taskStatus;
    private String duration;

    public Task(String category, String description, TaskStatus taskStatus, String duration) {
        this.id = UUID.randomUUID().toString();
        this.category = category;
        this.description = description;
        this.taskStatus = taskStatus;
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
        return taskStatus;
    }

    public void setStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
