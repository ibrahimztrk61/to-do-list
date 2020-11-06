package com.ibrahim.entities;

import java.util.Objects;
import java.util.UUID;

public class Task {

    private String id;
    private String userId;
    private String category;
    private String description;
    private TaskStatus taskStatus;
    private String duration;

    public Task(String userId, String category, String description, TaskStatus taskStatus, String duration) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", taskStatus=" + taskStatus +
                ", duration='" + duration + '\'' +
                '}';
    }
}
