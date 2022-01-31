package com.ndourcodeur.microservices.prequalifynowservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Pre_Qualify_Driver_tb", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@NoArgsConstructor @AllArgsConstructor @Data @ToString
public class PreQualifyDriver {

    @Id @GeneratedValue
    private Long id;

    @NotBlank(message = "This field is required!")
    private String firstName;

    @NotBlank(message = "This field is required!")
    private String lastName;

    @NotBlank(message = "This field is required!")
    @Email(message = "Please, Enter a valid email address")
    private String email;

    @NotBlank(message = "This field is required!")
    private String phoneNumber;

    @NotBlank(message = "This field is required!")
    private String city;

    @Enumerated(EnumType.STRING)
    private State state;

    @NotBlank(message = "This field is required!")
    private String zipCode;

    @Enumerated(EnumType.STRING)
    private CurrentExperienceLevel currentExperienceLevel;

    @Enumerated(EnumType.STRING)
    private Screen screen;

    @Enumerated(EnumType.STRING)
    private MovingViolation movingViolation;

    @Enumerated(EnumType.STRING)
    private Accident accident;

    @Enumerated(EnumType.STRING)
    private LifeTime lifeTime;

    @Enumerated(EnumType.STRING)
    private  Employer employer;

}
