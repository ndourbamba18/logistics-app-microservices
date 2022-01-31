package com.ndourcodeur.microservices.freightquoteservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "freight_quote_tb" /*, uniqueConstraints = {@UniqueConstraint(columnNames = "email")}*/)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class FreightQuote {

    @Id @GeneratedValue
    private Long id;

    @NotBlank(message = "This field is required!")
    private String firstName;

    @NotBlank(message = "This field is required!")
    private String lastName;

    @NotBlank(message = "This field is required!")
    private String companyName;

    @NotBlank(message = "This field is required!")
    @Email(message = "Enter a valid email.")
    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private ChooseQuoteType chooseQuoteType;

    @NotBlank(message = "This field is required!")
    private String message;
    
    @Enumerated(EnumType.STRING)
    private Selected selected;

    private boolean used;
}
