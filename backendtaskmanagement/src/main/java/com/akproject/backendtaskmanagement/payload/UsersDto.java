package com.akproject.backendtaskmanagement.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto {
    private Long id;
    private String name;
    private String password;
    private String email;
}
