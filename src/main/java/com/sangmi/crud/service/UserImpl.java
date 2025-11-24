package com.sangmi.crud.service;

import com.sangmi.crud.dataMapper.UserMapper;
import com.sangmi.crud.dtos.UserDTO;
import com.sangmi.crud.model.User;
import com.sangmi.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImpl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper mapper;

    public List<UserDTO> getUsers(){
        List<User> users = this.userRepository.findAll();
        return users.stream()
                .map(user -> mapper.entityToDto(user))
                .collect(Collectors.toList());
    }
}
