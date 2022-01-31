package com.ndourcodeur.microservices.apigatewayservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/contactServiceFallBack")
    public String contactServiceFallBackMethod() {
        return "Contact Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/freightQuoteServiceFallBack")
    public String freightQuoteServiceFallBackMethod() {
        return "Freight Quote Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/teamServiceFallBack")
    public String teamServiceFallBackMethod() {
        return "Team Driver Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/availableServiceFallBack")
    public String availableServiceFallBackMethod() {
        return "Available Driver Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/qualifyServiceFallBack")
    public String qualifyServiceFallBackMethod() {
        return "Pre Qualify Now Service is taking longer than Expected." +
                " Please try again later";
    }
}
