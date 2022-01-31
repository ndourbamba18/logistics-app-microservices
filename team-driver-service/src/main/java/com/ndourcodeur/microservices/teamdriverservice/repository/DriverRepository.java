package com.ndourcodeur.microservices.teamdriverservice.repository;

import com.ndourcodeur.microservices.teamdriverservice.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    public Driver findByEmailContaining(String email);

    public boolean existsByEmail(String email);
}
