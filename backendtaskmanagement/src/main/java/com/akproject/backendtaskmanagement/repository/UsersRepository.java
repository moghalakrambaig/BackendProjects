package com.akproject.backendtaskmanagement.repository;

import com.akproject.backendtaskmanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
