package com.ndourcodeur.microservices.registrationuserservice.dto;

import com.ndourcodeur.microservices.registrationuserservice.models.Gender;
import com.ndourcodeur.microservices.registrationuserservice.models.User;
import lombok.Data;

import java.util.Date;

@Data
public class ProfileDto {

    private Long id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private Gender gender;
    private String zipCode;
    private String bio;
    //private User user;
}
