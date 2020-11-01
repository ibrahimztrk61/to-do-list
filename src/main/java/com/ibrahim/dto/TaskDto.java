package com.ibrahim.dto;

import java.util.UUID;

public class TaskDto {

    private String id;
    private String category;
    private String description;
    private String duration;

    public TaskDto(String id, String category, String description, String duration) {
        this.id = UUID.randomUUID().toString();
        this.category = category;
        this.description = description;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
