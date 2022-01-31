package com.ndourcodeur.microservices.availabledriverjobsservice.service;

import com.ndourcodeur.microservices.availabledriverjobsservice.dto.AvailableDriverRequest;
import com.ndourcodeur.microservices.availabledriverjobsservice.entity.AvailableDriver;
import com.ndourcodeur.microservices.availabledriverjobsservice.exception.ResourceNotFoundException;
import com.ndourcodeur.microservices.availabledriverjobsservice.repository.AvailableDriverRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AvailableDriverServiceImpl implements AvailableDriverService {

    private final AvailableDriverRepository availableDriverRepository;

    public AvailableDriverServiceImpl(AvailableDriverRepository availableDriverRepository) {
        this.availableDriverRepository = availableDriverRepository;
    }

    @Override
    public AvailableDriver addAvailableDriver(AvailableDriverRequest request) {
        AvailableDriver driver = new AvailableDriver();
        driver.setId(request.getId());
        driver.setName(request.getName());
        driver.setPhoneNumber(request.getPhoneNumber());
        driver.setAveragePay(request.getAveragePay());
        driver.setTopPerformersEarning(request.getTopPerformersEarning());
        driver.setHomeTime(request.getHomeTime());
        driver.setGuaranteedWeeklyPay(request.getGuaranteedWeeklyPay());
        driver.setSignOnWeeklyPay(request.getSignOnWeeklyPay());
        driver.setDescription(request.getDescription());
        return availableDriverRepository.save(driver);
    }

    @Override
    public AvailableDriver updateAvailableDriver(Long id, AvailableDriverRequest request) {
        AvailableDriver driver = availableDriverRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Resource not found with ID:"+id));
        driver.setId(request.getId());
        driver.setName(request.getName());
        driver.setPhoneNumber(request.getPhoneNumber());
        driver.setAveragePay(request.getAveragePay());
        driver.setTopPerformersEarning(request.getTopPerformersEarning());
        driver.setHomeTime(request.getHomeTime());
        driver.setGuaranteedWeeklyPay(request.getGuaranteedWeeklyPay());
        driver.setSignOnWeeklyPay(request.getSignOnWeeklyPay());
        driver.setDescription(request.getDescription());
        return availableDriverRepository.save(driver);
    }

    @Override
    public List<AvailableDriver> fetchAllAvailableDrivers() {
        return availableDriverRepository.findAll();
    }

    @Override
    public AvailableDriver fetchAvailableDriver(Long id) {
        AvailableDriver driver = availableDriverRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Resource not found with ID:"+id));
        return driver;
    }

    @Override
    public void deleteAvailableDriver(Long id) {
        AvailableDriver driver = availableDriverRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Resource not found with ID:"+id));
        availableDriverRepository.delete(driver);
    }

    @Override
    public AvailableDriver findName(String name) {
        return availableDriverRepository.findByNameContaining(name);
    }

    @Override
    public boolean existsByName(String name) {
        return availableDriverRepository.existsByName(name);
    }
}
