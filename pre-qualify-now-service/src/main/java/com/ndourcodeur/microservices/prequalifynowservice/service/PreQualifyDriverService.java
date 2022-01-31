package com.ndourcodeur.microservices.prequalifynowservice.service;

import com.ndourcodeur.microservices.prequalifynowservice.dto.PreQualifyDriverDto;
import com.ndourcodeur.microservices.prequalifynowservice.entity.PreQualifyDriver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PreQualifyDriverService {

    public PreQualifyDriver addPreQualifyDriver(PreQualifyDriverDto request);
    public PreQualifyDriver updatePreQualifyDriver(Long id, PreQualifyDriverDto dto);
    public List<PreQualifyDriver> fetchAllPreQualifyDriver();
    public PreQualifyDriver fetchPreQualifyDriver(Long id);
    public void deletePreQualifyDriver(Long id);
    public PreQualifyDriver findEmail(String email);
    public boolean existsByEmail(String email);
}
