package com.sangmi.crud.controller;

import com.sangmi.crud.dtos.UserDTO;
import com.sangmi.crud.service.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserImpl userImpl;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> response = this.userImpl.getUsers();
        return new ResponseEntity<List<UserDTO>>(response, HttpStatus.OK);
    }

}
