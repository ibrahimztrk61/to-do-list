package com.ibrahim.dtos;

public class UpdateTaskDto {

    private String category;
    private String description;
    private String duration;

    public UpdateTaskDto(String category, String description, String duration) {
        this.category = category;
        this.description = description;
        this.duration = duration;
    }

    public UpdateTaskDto() {
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
