package com.ndourcodeur.microservices.freightquoteservice.dto;

import com.ndourcodeur.microservices.freightquoteservice.entity.ChooseQuoteType;
import com.ndourcodeur.microservices.freightquoteservice.entity.Selected;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class FreightQuoteRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String email;
    private String phoneNumber;
    private ChooseQuoteType chooseQuoteType;
    private String message;
    private Selected selected;
    private boolean used;
}
