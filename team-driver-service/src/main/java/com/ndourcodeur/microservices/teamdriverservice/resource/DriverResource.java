package com.ndourcodeur.microservices.teamdriverservice.resource;

import com.ndourcodeur.microservices.teamdriverservice.dto.DriverDto;
import com.ndourcodeur.microservices.teamdriverservice.entity.Driver;
import com.ndourcodeur.microservices.teamdriverservice.message.Message;
import com.ndourcodeur.microservices.teamdriverservice.sersives.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/drivers")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class DriverResource {

    private final DriverService driverService;

    public DriverResource(DriverService driverService) {
        this.driverService = driverService;
    }

    /**
     *    URL ===> http://localhost:8001/drivers/add
     */
    @PostMapping(path = "/add")
    public ResponseEntity<?> addNewDriver(@Valid @RequestBody DriverDto dto){
        if (driverService.existsByEmail(dto.getEmail())){
            return new ResponseEntity<>(new Message("Email already exist!"), HttpStatus.BAD_REQUEST);
        }
        Driver driver = driverService.addDriver(dto);
        return new ResponseEntity<>(driver, HttpStatus.CREATED);
    }

    /**
     *    URL ===> http://localhost:8001/drivers/{id}
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateDriverById(@Valid @RequestBody DriverDto dto, @PathVariable Long id){
        if (driverService.existsByEmail(dto.getEmail()) && driverService.getEmail(dto.getEmail()).getId() != id){
            return new ResponseEntity<>(new Message("Email already exist!"), HttpStatus.BAD_REQUEST);
        }
        Driver driver = driverService.editDriver(dto, id);
        return new ResponseEntity<>(driver, HttpStatus.OK);
    }

    /**
     *    URL ===> http://localhost:8001/drivers/all
     */
    @GetMapping(path = "/all")
    public ResponseEntity<?> findAllDrivers(){
        List<Driver> drivers = driverService.fetchAllDrivers();
        if (drivers.isEmpty())
            return new ResponseEntity<>(new Message("Sorry, No Content Here"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    /**
     *    URL ===> http://localhost:8001/drivers/{id}
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findDriverById(@PathVariable Long id){
        Driver driver = driverService.fetchOneDriver(id);
        return new ResponseEntity<>(driver, HttpStatus.OK);
    }

    /**
     *    URL ===> http://localhost:8001/drivers/{id}
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long id){
        driverService.deleteDriver(id);
        return new ResponseEntity<>(new Message("Driver with ID:"+id+" deleted successfully!"), HttpStatus.BAD_REQUEST);
    }
}
