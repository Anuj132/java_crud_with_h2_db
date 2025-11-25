package com.sangmi.crud.dataMapper;

import com.sangmi.crud.dtos.AddressDTO;
import com.sangmi.crud.dtos.UserDTO;
import com.sangmi.crud.model.Address;
import com.sangmi.crud.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private Logger log = LoggerFactory.getLogger("UserImpl");

    public UserDTO entityToDto(User user) {
        if (user == null) {
            return null;
        }
        log.info("user is: ",user);
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setMobileNumber(user.getMobileNumber());
        AddressDTO ato = new AddressDTO();
        log.info("address is: ",user.getAddress());
        ato.setAddressId(user.getAddress().getId());
        ato.setCity(user.getAddress().getCity());
        ato.setState(user.getAddress().getState());
        ato.setPinCode(user.getAddress().getPinCode());
        userDto.setAddress(ato);

        return userDto;
    }

    public User DtoToEntity(UserDTO userDto){
        if(userDto == null){
            return null;
        }
        log.info("userDTo: ", userDto);
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setMobileNumber(userDto.getMobileNumber());
        log.info("addressDto: ", userDto.getAddress());
        Address address = new Address();
        address.setCity(userDto.getAddress().getCity());
        address.setState(userDto.getAddress().getState());
        address.setPinCode(userDto.getAddress().getPinCode());
        user.setAddress(address);
        return user;
    }
}
