package com.akproject.backendtaskmanagement.controller;

import com.akproject.backendtaskmanagement.payload.TaskDto;
import com.akproject.backendtaskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/{userId}/tasks")
    public ResponseEntity<TaskDto> saveTask(@PathVariable("userId") Long userId, @RequestBody TaskDto taskDto) {
        return new ResponseEntity<>(taskService.saveTask(userId, taskDto), HttpStatus.CREATED);
    }

    @GetMapping("/tasks/{userId}")
    public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(taskService.getAllTasks(userId), HttpStatus.OK);
    }

    @GetMapping("{userId}/tasks/{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable("userId") Long userId, @PathVariable("taskId") Long taskId) {
        return new ResponseEntity<>(taskService.getTask(userId, taskId), HttpStatus.OK);
    }

    @DeleteMapping("{userId}/tasks/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable("userId") Long userId, @PathVariable("taskId") Long taskId) {
        taskService.deleteTask(userId, taskId);
        return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
    }
}
