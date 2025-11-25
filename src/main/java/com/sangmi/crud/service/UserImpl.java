package com.sangmi.crud.service;

import com.sangmi.crud.dataMapper.UserMapper;
import com.sangmi.crud.dtos.UserDTO;
import com.sangmi.crud.exception.UserNotFoundException;
import com.sangmi.crud.model.Address;
import com.sangmi.crud.model.User;
import com.sangmi.crud.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImpl {

    private Logger log = LoggerFactory.getLogger("UserImpl");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = mapper.DtoToEntity(userDTO);
        log.info("user for add: ", user);
        user = userRepository.save(user);
        return mapper.entityToDto(user);
    }

    public String updateUser(Long id, UserDTO usr) {
        try{
            User optionalUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
            User user = optionalUser;
            user.setName(usr.getName());
            user.setEmail(usr.getEmail());
            user.setMobileNumber(usr.getMobileNumber());

            Address address = user.getAddress();
            if (address == null) {
                address = new Address();
            }
            address.setCity(usr.getAddress().getCity());
            address.setState(usr.getAddress().getState());
            address.setPinCode(usr.getAddress().getPinCode());
            user.setAddress(address);
            userRepository.save(user);
        } catch(UserNotFoundException ex){
            log.error("Somethin goes wrong",ex.getMessage());
        }
        return "user updated with Id: "+id;
    }

    public String deleteUser(Long id) {
        try{
            User optionalUser = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
            userRepository.deleteById(id);
        } catch(UserNotFoundException ex){
            log.error("Somethin goes wrong",ex.getMessage());
        }
        return "deleted user with Id:"+id;
    }
}
