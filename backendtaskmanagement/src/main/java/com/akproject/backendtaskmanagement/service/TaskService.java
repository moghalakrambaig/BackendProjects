package com.akproject.backendtaskmanagement.service;

import com.akproject.backendtaskmanagement.payload.TaskDto;

import java.util.List;

public interface TaskService {
    public TaskDto saveTask(Long userId, TaskDto taskDto);

    public List<TaskDto> getAllTasks(Long userId);
}
