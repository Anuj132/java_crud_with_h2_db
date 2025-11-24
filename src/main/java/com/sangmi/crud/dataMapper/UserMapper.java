package com.sangmi.crud.dataMapper;

import com.sangmi.crud.dtos.UserDTO;
import com.sangmi.crud.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO entityToDto(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setMobileNumber(user.getMobileNumber());
        userDto.setAddress(user.getAddress());

        return userDto;
    }

    public User DtoToEntity(UserDTO userDto){
        if(userDto == null){
            return null;
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setAddress(userDto.getAddress());

        return user;
    }
}
