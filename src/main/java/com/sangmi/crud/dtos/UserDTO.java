package com.sangmi.crud.dtos;

import com.sangmi.crud.model.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor      // Generates no-args constructor
@AllArgsConstructor     // Generates all-args constructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private AddressDTO address;
}
