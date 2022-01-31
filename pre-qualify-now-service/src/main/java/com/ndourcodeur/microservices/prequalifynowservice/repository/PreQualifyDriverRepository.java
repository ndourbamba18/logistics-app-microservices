package com.ndourcodeur.microservices.prequalifynowservice.repository;

import com.ndourcodeur.microservices.prequalifynowservice.entity.PreQualifyDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreQualifyDriverRepository extends JpaRepository<PreQualifyDriver, Long> {

    public PreQualifyDriver findByEmailContaining(String email);

    public boolean existsByEmail(String email);
}
