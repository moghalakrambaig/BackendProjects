package com.akproject.backendtaskmanagement.serviceImpl;

import com.akproject.backendtaskmanagement.entity.Users;
import com.akproject.backendtaskmanagement.payload.UsersDto;
import com.akproject.backendtaskmanagement.repository.UsersRepository;
import com.akproject.backendtaskmanagement.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    private UsersRepository userRepository;

    @Override
    public void createUser(UsersDto usersDto) {
    userRepository.save();
    }
    private Users userDtoToEntity(UsersDto usersDto){
        Users users = new Users();
        users.setName(usersDto.getName());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        return users;
    }

    private UsersDto entityToUserDto(Users users){
        UsersDto usersDto = new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setName(users.getName());
        usersDto.setEmail(users.getEmail());
        usersDto.setPassword(users.getPassword());
        return usersDto;

    }
}
