package com.ndourcodeur.microservices.contactservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author NdourCodeur
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ContactForm {

    @NotBlank(message = "This field is required!")
    @Size(max = 100, message = "First Name must be contain 100 characters long!")
    private String firstName;

    @NotBlank(message = "This field is required!")
    @Size(max = 100, message = "Last Name must be contain 100 characters long!")
    private String lastName;

    @NotBlank(message = "This field is required!")
    @Email(message = "Please, Enter a valid email address")
    @Size(max = 180, message = "Email Address must be contain 180 characters long!")
    private String email;

    @NotBlank(message = "This field is required!")
    @Size(max = 25, message = "Phone Number must be contain 25 characters long!")
    private String phoneNumber;

    private String subject;

    private String message;
}
