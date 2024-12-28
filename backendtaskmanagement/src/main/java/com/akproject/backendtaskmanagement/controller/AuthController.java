package com.akproject.backendtaskmanagement.controller;

import com.akproject.backendtaskmanagement.entity.Users;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public void createUser(@RequestBody Users users){

    }
}
