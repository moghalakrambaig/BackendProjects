package com.akproject.backendtaskmanagement.repository;

import com.akproject.backendtaskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
