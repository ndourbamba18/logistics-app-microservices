package com.ndourcodeur.microservices.availabledriverjobsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AvailableDriverRequest {

    private Long id;
    private String name;
    private String phoneNumber;
    private String averagePay;
    private String topPerformersEarning;
    private String homeTime;
    private String guaranteedWeeklyPay;
    private String signOnWeeklyPay;
    private String description;
}
