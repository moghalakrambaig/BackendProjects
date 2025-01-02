package com.akproject.backendtaskmanagement.serviceImpl;

import com.akproject.backendtaskmanagement.entity.Task;
import com.akproject.backendtaskmanagement.entity.Users;
import com.akproject.backendtaskmanagement.exceptions.UserNotFoundException;
import com.akproject.backendtaskmanagement.payload.TaskDto;
import com.akproject.backendtaskmanagement.repository.TaskRepository;
import com.akproject.backendtaskmanagement.repository.UsersRepository;
import com.akproject.backendtaskmanagement.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskDto saveTask(Long userId, TaskDto taskDto) {
        Users user = usersRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(String.format("User Id %d not found", userId))
        );
        Task task = modelMapper.map(taskDto, Task.class);
        task.setUsers(user);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask, TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks(Long userId) {
        Users user = usersRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(String.format("User Id %d not found", userId))
        );
        List<Task> tasks = taskRepository.findAllByUserId(userId);
        return tasks.stream().map(
                task -> modelMapper.map(tasks, TaskDto.class)
        ).toList();
    }
}
