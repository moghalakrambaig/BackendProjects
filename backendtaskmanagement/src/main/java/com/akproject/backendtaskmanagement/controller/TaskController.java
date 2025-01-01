package com.akproject.backendtaskmanagement.controller;

import com.akproject.backendtaskmanagement.payload.TaskDto;
import com.akproject.backendtaskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/{userId}/tasks")
    public ResponseEntity<TaskDto> saveTask(@PathVariable("userId") Long userId, @RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.saveTask(userId, taskDto), HttpStatus.CREATED);
    }
}
