package com.ndourcodeur.microservices.teamdriverservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "driver_tb", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@NoArgsConstructor @AllArgsConstructor @Data @ToString
public class Driver {

    @Id @GeneratedValue
    private Long id;

    @NotBlank(message = "This field is required!")
    @Size(min = 2, message = "First Name must be at least 2 characters long.")
    private String firstName;

    @NotBlank(message = "This field is required!")
    @Size(min = 2, message = "First Name must be at least 2 characters long.")
    private String lastName;

    @Email(message = "Enter a valid email please.")
    @NotBlank(message = "This field is required!")
    @Size(max = 180, message = "Email must not exceed 180 characters.")
    private String email;

    @NotBlank(message = "This field is required!")
    @Size(max = 25, message = "Phone Number must not exceed 25 characters.")
    private String phoneNumber;

    private boolean currentDriver;

    private boolean cdl;
}
