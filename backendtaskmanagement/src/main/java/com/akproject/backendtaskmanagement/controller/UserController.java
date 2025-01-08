package com.akproject.backendtaskmanagement.controller;

import com.akproject.backendtaskmanagement.payload.JwtTokenResponse;
import com.akproject.backendtaskmanagement.payload.LoginDto;
import com.akproject.backendtaskmanagement.payload.UsersDto;
import com.akproject.backendtaskmanagement.secutiry.JwtTokenProvider;
import com.akproject.backendtaskmanagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto) {
        return new ResponseEntity<>(usersService.createUser(usersDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenResponse> loginUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication); //get the token
        return new ResponseEntity<>(new JwtTokenResponse(token), HttpStatus.OK);
    }
}
