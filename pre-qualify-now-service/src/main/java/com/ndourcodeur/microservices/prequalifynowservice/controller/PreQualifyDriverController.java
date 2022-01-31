package com.ndourcodeur.microservices.prequalifynowservice.controller;

import com.ndourcodeur.microservices.prequalifynowservice.dto.PreQualifyDriverDto;
import com.ndourcodeur.microservices.prequalifynowservice.entity.PreQualifyDriver;
import com.ndourcodeur.microservices.prequalifynowservice.message.Message;
import com.ndourcodeur.microservices.prequalifynowservice.service.PreQualifyDriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/preQualifyDrivers")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class PreQualifyDriverController {

    private final PreQualifyDriverService preQualifyDriverService;

    public PreQualifyDriverController(PreQualifyDriverService preQualifyDriverService) {
        this.preQualifyDriverService = preQualifyDriverService;
    }


    /**
     *   URL ===> http://localhost:8002/api/v1/preQualifyDrivers/add
     */
    @PostMapping(path = "/add")
    public ResponseEntity<?> addNewPreQualifyDriver(@Valid @RequestBody PreQualifyDriverDto request){
        if (preQualifyDriverService.existsByEmail(request.getEmail())){
            return new ResponseEntity<>(new Message("Email already exist!"), HttpStatus.BAD_REQUEST);
        }
        PreQualifyDriver driver = preQualifyDriverService.addPreQualifyDriver(request);
        return new ResponseEntity<>(driver, HttpStatus.CREATED);
    }

    /**
     *   URL ===> http://localhost:8002/api/v1/preQualifyDrivers/{id}
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updatePreQualifyDriver(@PathVariable Long id, @Valid @RequestBody PreQualifyDriverDto dto){
        if (preQualifyDriverService.existsByEmail(dto.getEmail()) && preQualifyDriverService.findEmail(dto.getEmail()).getId() != id){
            return new ResponseEntity<>(new Message("Resource Email already exist!"), HttpStatus.BAD_REQUEST);
        }
        PreQualifyDriver driver = preQualifyDriverService.updatePreQualifyDriver(id, dto);
        return new ResponseEntity<>(driver, HttpStatus.CREATED);
    }

    /**
     *   URL ===> http://localhost:8002/api/v1/preQualifyDrivers/all
     */
    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllPreQualifyDrivers(){
        List<PreQualifyDriver> drivers = preQualifyDriverService.fetchAllPreQualifyDriver();
        if (drivers.isEmpty()){
            return new ResponseEntity<>(new Message("Sorry, There are no content Here!"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    /**
     *   URL ===> http://localhost:8002/api/v1/preQualifyDrivers/{id}
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getPreQualifyDriverNow(@PathVariable Long id){
        return new ResponseEntity<>(preQualifyDriverService.fetchPreQualifyDriver(id), HttpStatus.OK);
    }

    /**
     *   URL ===> http://localhost:8002/api/v1/preQualifyDrivers/{id}
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletePrequalifyDriverById(@PathVariable Long id){
        preQualifyDriverService.deletePreQualifyDriver(id);
        return new ResponseEntity<>(new Message("Resource deleted successfully with ID:"+id), HttpStatus.OK);
    }
}
