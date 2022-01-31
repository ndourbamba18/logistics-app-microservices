package com.ndourcodeur.microservices.teamdriverservice.sersives;

import com.ndourcodeur.microservices.teamdriverservice.dto.DriverDto;
import com.ndourcodeur.microservices.teamdriverservice.entity.Driver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DriverService {

    public Driver addDriver(DriverDto dto);
    public Driver editDriver(DriverDto dto, Long id);
    public List<Driver> fetchAllDrivers();
    public Driver fetchOneDriver(Long id);
    public void deleteDriver(Long id);

    public Driver getEmail(String email);
    public boolean existsByEmail(String email);
}
