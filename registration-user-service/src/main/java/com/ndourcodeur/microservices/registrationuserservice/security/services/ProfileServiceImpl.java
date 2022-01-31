package com.ndourcodeur.microservices.registrationuserservice.security.services;

import com.ndourcodeur.microservices.registrationuserservice.dto.ProfileDto;
import com.ndourcodeur.microservices.registrationuserservice.exception.ResourceNotFoundException;
import com.ndourcodeur.microservices.registrationuserservice.models.Profile;
import com.ndourcodeur.microservices.registrationuserservice.repository.ProfileRepository;
import com.ndourcodeur.microservices.registrationuserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Profile addProfile(Long idUser, Profile profile) {
        return userRepository.findById(idUser)
                .map(user -> {
                    profile.setUser(user);
                    return profileRepository.save(profile);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with ID:"+idUser));
    }

    @Override
    public Profile editProfile(ProfileDto dto, Long idProfile) {
        Profile profile = profileRepository.findById(idProfile).get();
        profile.setId(dto.getId());
        profile.setFullName(dto.getFullName());
        profile.setPhoneNumber(dto.getPhoneNumber());
        profile.setAddress(dto.getAddress());
        profile.setGender(dto.getGender());
        profile.setZipCode(dto.getZipCode());
        profile.setBio(dto.getBio());
        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> fetchProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile fetchProfileById(Long idProfile) {
        Profile profile = profileRepository.findById(idProfile).get();
        return profile;
    }

    @Override
    public void deleteProfileById(Long idProfile) {
        Profile profile = profileRepository.findById(idProfile).get();
        profileRepository.delete(profile);
    }

    @Override
    public boolean existsById(Long id) {
        return profileRepository.existsById(id);
    }
}
