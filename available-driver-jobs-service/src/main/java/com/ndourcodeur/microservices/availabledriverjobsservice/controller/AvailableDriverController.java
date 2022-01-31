package com.ndourcodeur.microservices.availabledriverjobsservice.controller;

import com.ndourcodeur.microservices.availabledriverjobsservice.dto.AvailableDriverRequest;
import com.ndourcodeur.microservices.availabledriverjobsservice.entity.AvailableDriver;
import com.ndourcodeur.microservices.availabledriverjobsservice.message.Message;
import com.ndourcodeur.microservices.availabledriverjobsservice.service.AvailableDriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/availableDrivers")
@CrossOrigin(origins = "*")
public class AvailableDriverController {

    private final AvailableDriverService availableDriverService;

    public AvailableDriverController(AvailableDriverService availableDriverService) {
        this.availableDriverService = availableDriverService;
    }

    /**
     *  URL ===> http://localhost:8003/api/v1/availableDrivers/add
     */
    @PostMapping(path = "/add")
    public ResponseEntity<?> addNewAvailableDriver(@Valid @RequestBody AvailableDriverRequest request){
        if (availableDriverService.existsByName(request.getName())){
            return new ResponseEntity<>(new Message("Name already exist!"), HttpStatus.BAD_REQUEST);
        }
        AvailableDriver driver = availableDriverService.addAvailableDriver(request);
        return new ResponseEntity<>(driver, HttpStatus.CREATED);
    }

    /**
     *  URL ===> http://localhost:8003/api/v1/availableDrivers/{id}
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateAvailableDriverById(@PathVariable Long id, @Valid @RequestBody AvailableDriverRequest request){
        if (availableDriverService.existsByName(request.getName()) && availableDriverService.findName(request.getName()).getId() != id){
            return new ResponseEntity<>(new Message("Resource Name already exist!"), HttpStatus.BAD_REQUEST);
        }
        AvailableDriver availableDriver = availableDriverService.updateAvailableDriver(id, request);
        return new ResponseEntity<>(availableDriver, HttpStatus.CREATED);
    }

    /**
     *  URL ===> http://localhost:8003/api/v1/availableDrivers/all
     */
    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllAvailableDrivers(){
        List<AvailableDriver> drivers = availableDriverService.fetchAllAvailableDrivers();
        if (drivers.isEmpty()){
            return new ResponseEntity<>(new Message("Sorry, There is no content here!"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    /**
     *  URL ===> http://localhost:8003/api/v1/availableDrivers/{id}
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAvailableDriverById(@PathVariable Long id){
        AvailableDriver availableDriver = availableDriverService.fetchAvailableDriver(id);
        return new ResponseEntity<>(availableDriver, HttpStatus.OK);
    }

    /**
     *  URL ===> http://localhost:8003/api/v1/availableDrivers/{id}
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAvailableDriver(@PathVariable Long id){
        availableDriverService.deleteAvailableDriver(id);
        return new ResponseEntity<>(new Message("Resource deleted successfully with ID:"+id), HttpStatus.OK);
    }
}
