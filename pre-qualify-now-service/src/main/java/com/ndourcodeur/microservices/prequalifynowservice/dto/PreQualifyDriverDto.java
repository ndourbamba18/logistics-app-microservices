package com.ndourcodeur.microservices.prequalifynowservice.dto;

import com.ndourcodeur.microservices.prequalifynowservice.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor @Data
public class PreQualifyDriverDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private State state;
    private String zipCode;
    private CurrentExperienceLevel currentExperienceLevel;
    private Screen screen;
    private MovingViolation movingViolation;
    private Accident accident;
    private LifeTime lifeTime;
    private  Employer employer;

}
