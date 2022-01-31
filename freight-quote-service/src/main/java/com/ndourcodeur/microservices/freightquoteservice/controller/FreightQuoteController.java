package com.ndourcodeur.microservices.freightquoteservice.controller;

import com.ndourcodeur.microservices.freightquoteservice.dto.FreightQuoteRequest;
import com.ndourcodeur.microservices.freightquoteservice.entity.FreightQuote;
import com.ndourcodeur.microservices.freightquoteservice.message.Message;
import com.ndourcodeur.microservices.freightquoteservice.service.FreightQuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/freightQuotes")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost/3000"})
@Slf4j
public class FreightQuoteController {

    private final FreightQuoteService freightQuoteService;

    public FreightQuoteController(FreightQuoteService freightQuoteService) {
        this.freightQuoteService = freightQuoteService;
    }

    /**
     *    URL ===>  http://localhost:8004/api/v1/freightQuotes/add
     */
    @PostMapping(path = "/add")
    public ResponseEntity<?> addNewFreightQuote(@Valid @RequestBody FreightQuoteRequest request){

        FreightQuote quote = freightQuoteService.addFreightQuote(request);
        log.info("Inside addNewFreightQuote of FreightQuoteController");
        return new ResponseEntity<>(quote, HttpStatus.CREATED);
    }

    /**
     *    URL ===>  http://localhost:8004/api/v1/freightQuotes/update/{id}
     */
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updateFreightQuote(@PathVariable Long id, @Valid @RequestBody FreightQuoteRequest request){
        FreightQuote quote = freightQuoteService.updateFreightQuote(id, request);
        log.info("Inside updateFreightQuote of FreightQuoteController");
        return new ResponseEntity<>(quote, HttpStatus.CREATED);
    }

    /**
     *    URL ===>  http://localhost:8004/api/v1/freightQuotes/{id}
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getFreightQuote(@PathVariable("id") Long id) {
        log.info("Inside getFreightQuote of FreightQuoteController");
        return new ResponseEntity<>(freightQuoteService.fetchFreightQuote(id), HttpStatus.OK);
    }

    /**
     *    URL ===>  http://localhost:8004/api/v1/freightQuotes/all
     */
    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllFreightQuote(){
        List<FreightQuote> quotes = freightQuoteService.fetchAllFreightQuote();
        if (quotes.isEmpty()){
            return new ResponseEntity<>(new Message("Sorry, There are no resource Here!"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    /**
     *    URL ===>  http://localhost:8004/api/v1/freightQuotes/{id}
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteFreightQuoteById(@PathVariable Long id){
        freightQuoteService.deleteFreightQuote(id);
        return new ResponseEntity<>(new Message("Resource deleted successfully with ID:"+id), HttpStatus.OK);
    }
}
