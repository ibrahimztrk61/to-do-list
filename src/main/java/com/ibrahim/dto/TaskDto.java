package com.ibrahim.dto;

import com.ibrahim.entities.TaskStatus;

import java.util.UUID;

public class TaskDto {

    private String id;
    private String userId;
    private String category;
    private String description;
    private String duration;
    private TaskStatus taskStatus;

    public TaskDto(String id, String category, String description, String duration) {
        this.id = UUID.randomUUID().toString();
        this.category = category;
        this.description = description;
        this.duration = duration;
        this.taskStatus = TaskStatus.TODO;
    }

    public String getId() {
        return id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
