package com.ndourcodeur.microservices.prequalifynowservice.service;

import com.ndourcodeur.microservices.prequalifynowservice.dto.PreQualifyDriverDto;
import com.ndourcodeur.microservices.prequalifynowservice.entity.PreQualifyDriver;
import com.ndourcodeur.microservices.prequalifynowservice.repository.PreQualifyDriverRepository;
import org.hibernate.ResourceClosedException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PreQualifyDriverServiceImpl implements PreQualifyDriverService {

    private final PreQualifyDriverRepository preQualifyDriverRepository;

    public PreQualifyDriverServiceImpl(PreQualifyDriverRepository preQualifyDriverRepository) {
        this.preQualifyDriverRepository = preQualifyDriverRepository;
    }


    @Override
    public PreQualifyDriver addPreQualifyDriver(PreQualifyDriverDto dto) {
        PreQualifyDriver driver = new PreQualifyDriver();
        driver.setId(dto.getId());
        driver.setFirstName(dto.getFirstName());
        driver.setLastName(dto.getLastName());
        driver.setEmail(dto.getEmail());
        driver.setPhoneNumber(dto.getPhoneNumber());
        driver.setCity(dto.getCity());
        driver.setState(dto.getState());
        driver.setZipCode(dto.getZipCode());
        driver.setCurrentExperienceLevel(dto.getCurrentExperienceLevel());
        driver.setScreen(dto.getScreen());
        driver.setAccident(dto.getAccident());
        driver.setMovingViolation(dto.getMovingViolation());
        driver.setLifeTime(dto.getLifeTime());
        driver.setEmployer(dto.getEmployer());
        return preQualifyDriverRepository.save(driver);
    }

    @Override
    public PreQualifyDriver updatePreQualifyDriver(Long id, PreQualifyDriverDto dto) {
        PreQualifyDriver driver = preQualifyDriverRepository.findById(id)
                .orElseThrow( () -> new ResourceClosedException("Resource not found with ID:"+id));
        driver.setId(dto.getId());
        driver.setFirstName(dto.getFirstName());
        driver.setLastName(dto.getLastName());
        driver.setEmail(dto.getEmail());
        driver.setPhoneNumber(dto.getPhoneNumber());
        driver.setCity(dto.getCity());
        driver.setState(dto.getState());
        driver.setZipCode(dto.getZipCode());
        driver.setCurrentExperienceLevel(dto.getCurrentExperienceLevel());
        driver.setScreen(dto.getScreen());
        driver.setAccident(dto.getAccident());
        driver.setMovingViolation(dto.getMovingViolation());
        driver.setLifeTime(dto.getLifeTime());
        driver.setEmployer(dto.getEmployer());
        return preQualifyDriverRepository.save(driver);
    }

    @Override
    public List<PreQualifyDriver> fetchAllPreQualifyDriver() {
        return preQualifyDriverRepository.findAll();
    }

    @Override
    public PreQualifyDriver fetchPreQualifyDriver(Long id) {
        PreQualifyDriver existingDriver = preQualifyDriverRepository.findById(id)
                .orElseThrow( () -> new ResourceClosedException("Resource not found with ID:"+id));
        return existingDriver;
    }

    @Override
    public void deletePreQualifyDriver(Long id) {
        PreQualifyDriver existingDriver = preQualifyDriverRepository.findById(id)
                .orElseThrow( () -> new ResourceClosedException("Resource not found with ID:"+id));
        preQualifyDriverRepository.delete(existingDriver);
    }

    @Override
    public PreQualifyDriver findEmail(String email) {
        return preQualifyDriverRepository.findByEmailContaining(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return preQualifyDriverRepository.existsByEmail(email);
    }

}
