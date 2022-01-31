package com.ndourcodeur.microservices.availabledriverjobsservice.repository;

import com.ndourcodeur.microservices.availabledriverjobsservice.entity.AvailableDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvailableDriverRepository extends JpaRepository<AvailableDriver, Long> {

    public AvailableDriver findByNameContaining(String name);

    public boolean existsByName(String name);
}
