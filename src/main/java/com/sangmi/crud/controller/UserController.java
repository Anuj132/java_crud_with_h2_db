package com.sangmi.crud.controller;

import com.sangmi.crud.dtos.UserDTO;
import com.sangmi.crud.service.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user){
        UserDTO message = this.userImpl.addUser(user);
        return new ResponseEntity<UserDTO>(message, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, UserDTO userDto){
        String message = this.userImpl.updateUser(id,userDto);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
       String message =  this.userImpl.deleteUser(id);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
