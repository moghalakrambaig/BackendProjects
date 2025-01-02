package com.akproject.backendtaskmanagement.repository;

import com.akproject.backendtaskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUsersId(Long userId);
}
