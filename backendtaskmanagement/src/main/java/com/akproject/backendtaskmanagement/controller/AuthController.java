package com.akproject.backendtaskmanagement.controller;

import com.akproject.backendtaskmanagement.payload.UsersDto;
import com.akproject.backendtaskmanagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto) {
        return new ResponseEntity<>(usersService.createUser(usersDto), HttpStatus.CREATED);
    }
}
