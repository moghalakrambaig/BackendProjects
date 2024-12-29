package com.akproject.backendtaskmanagement.payload;

public class TaskDto {
    private Long id;
    private String taskName;

    public TaskDto() {
    }

    public TaskDto(Long id, String taskName) {
        this.id = id;
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
