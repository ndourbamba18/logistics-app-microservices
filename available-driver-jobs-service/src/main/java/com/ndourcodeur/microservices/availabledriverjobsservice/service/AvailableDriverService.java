package com.ndourcodeur.microservices.availabledriverjobsservice.service;

import com.ndourcodeur.microservices.availabledriverjobsservice.dto.AvailableDriverRequest;
import com.ndourcodeur.microservices.availabledriverjobsservice.entity.AvailableDriver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AvailableDriverService {

    public AvailableDriver addAvailableDriver(AvailableDriverRequest request);
    public AvailableDriver updateAvailableDriver(Long id, AvailableDriverRequest request);
    public List<AvailableDriver> fetchAllAvailableDrivers();
    public AvailableDriver fetchAvailableDriver(Long id);
    public void deleteAvailableDriver(Long id);
    public AvailableDriver findName(String name);
    public boolean existsByName(String name);
}
