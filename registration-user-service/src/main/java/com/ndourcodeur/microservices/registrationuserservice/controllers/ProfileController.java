package com.ndourcodeur.microservices.registrationuserservice.controllers;

import com.ndourcodeur.microservices.registrationuserservice.dto.ProfileDto;
import com.ndourcodeur.microservices.registrationuserservice.message.Message;
import com.ndourcodeur.microservices.registrationuserservice.models.Profile;
import com.ndourcodeur.microservices.registrationuserservice.repository.UserRepository;
import com.ndourcodeur.microservices.registrationuserservice.security.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/auth")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserRepository userRepository;

    /**
     *      URL ===>  http://localhost:8100/api/auth/users/{id}/profile/add
     **/
    @PostMapping(path = "/users/{idUser}/profile/add")
    public ResponseEntity<?> addNewProfile(@PathVariable Long idUser, @Valid @RequestBody Profile profile){
        Profile existsProfile = profileService.addProfile(idUser, profile);
        return new ResponseEntity<>(existsProfile, HttpStatus.CREATED);
    }

    /**
     *      URL ===>  http://localhost:8100/api/auth/profile/update/{id}
     **/
    @PutMapping(path = "/profile/update/{idProfile}")
    public ResponseEntity<?> editProfileById(@Valid @RequestBody ProfileDto dto, @PathVariable Long idProfile){
        if (!profileService.existsById(idProfile)){
            return new ResponseEntity<>(new Message("Profile not found with ID:"+idProfile), HttpStatus.BAD_REQUEST);
        }
        Profile profile = profileService.editProfile(dto, idProfile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }
}
