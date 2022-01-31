package com.ndourcodeur.microservices.teamdriverservice.sersives;

import com.ndourcodeur.microservices.teamdriverservice.dto.DriverDto;
import com.ndourcodeur.microservices.teamdriverservice.entity.Driver;
import com.ndourcodeur.microservices.teamdriverservice.exception.ResourceNotFoundException;
import com.ndourcodeur.microservices.teamdriverservice.repository.DriverRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver addDriver(DriverDto dto) {
        Driver driver = new Driver();
        driver.setId(dto.getId());
        driver.setFirstName(dto.getFirstName());
        driver.setLastName(dto.getLastName());
        driver.setEmail(dto.getEmail());
        driver.setPhoneNumber(dto.getPhoneNumber());
        driver.setCurrentDriver(dto.isCurrentDriver());
        driver.setCdl(dto.isCdl());
        return driverRepository.save(driver);
    }

    @Override
    public Driver editDriver(DriverDto dto, Long id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Driver not found with ID:"+id));
        driver.setId(dto.getId());
        driver.setFirstName(dto.getFirstName());
        driver.setLastName(dto.getLastName());
        driver.setEmail(dto.getEmail());
        driver.setPhoneNumber(dto.getPhoneNumber());
        driver.setCurrentDriver(dto.isCurrentDriver());
        driver.setCdl(dto.isCdl());
        return driverRepository.save(driver);
    }

    @Override
    public List<Driver> fetchAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver fetchOneDriver(Long id) {
        Driver existingDriver = driverRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Driver not found with ID:"+id));
        return existingDriver;
    }

    @Override
    public void deleteDriver(Long id) {
        Driver existingDriver = driverRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Driver not found with ID:"+id));
        driverRepository.delete(existingDriver);
    }

    @Override
    public Driver getEmail(String email) {
        Driver existingDriver = driverRepository.findByEmailContaining(email);
        return existingDriver;
    }

    @Override
    public boolean existsByEmail(String email) {
        return driverRepository.existsByEmail(email);
    }
}
