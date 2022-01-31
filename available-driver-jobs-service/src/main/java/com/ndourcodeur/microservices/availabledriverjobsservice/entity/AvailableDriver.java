package com.ndourcodeur.microservices.availabledriverjobsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "available_driver_tb", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AvailableDriver {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "This field is required!")
    private String name;

    @NotBlank(message = "This field is required!")
    private String phoneNumber;

    @NotBlank(message = "This field is required!")
    private String averagePay;

    @NotBlank(message = "This field is required!")
    private String topPerformersEarning;

    @NotBlank(message = "This field is required!")
    private String homeTime;

    @NotBlank(message = "This field is required!")
    private String guaranteedWeeklyPay;

    @NotBlank(message = "This field is required!")
    private String signOnWeeklyPay;

    @NotBlank(message = "This field is required!")
    @Lob
    private String description;
}
