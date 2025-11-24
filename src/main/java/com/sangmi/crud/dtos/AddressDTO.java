package com.sangmi.crud.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private int addressId;
    private String city;
    private String state;
    private int pinCode;
}
