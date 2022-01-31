package com.ndourcodeur.microservices.registrationuserservice.repository;

import com.ndourcodeur.microservices.registrationuserservice.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    boolean existsById(Long idProfile);
}
