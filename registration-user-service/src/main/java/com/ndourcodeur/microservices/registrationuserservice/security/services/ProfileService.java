package com.ndourcodeur.microservices.registrationuserservice.security.services;

import com.ndourcodeur.microservices.registrationuserservice.dto.ProfileDto;
import com.ndourcodeur.microservices.registrationuserservice.models.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfileService {

    Profile addProfile(Long idUser, Profile profile);
    Profile editProfile(ProfileDto dto, Long idProfile);
    List<Profile> fetchProfiles();
    Profile fetchProfileById(Long idProfile);
    void deleteProfileById(Long idProfile);
    boolean existsById(Long id);
}
