package com.ndourcodeur.microservices.freightquoteservice.service;

import com.ndourcodeur.microservices.freightquoteservice.dto.FreightQuoteRequest;
import com.ndourcodeur.microservices.freightquoteservice.entity.FreightQuote;
import com.ndourcodeur.microservices.freightquoteservice.exception.ResourceNotFoundException;
import com.ndourcodeur.microservices.freightquoteservice.repository.FreightQuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class FreightQuoteServiceImpl implements FreightQuoteService{

    private final FreightQuoteRepository freightQuoteRepository;

    public FreightQuoteServiceImpl(FreightQuoteRepository freightQuoteRepository) {
        this.freightQuoteRepository = freightQuoteRepository;
    }

    @Override
    public FreightQuote addFreightQuote(FreightQuoteRequest request) {
        FreightQuote quote = new FreightQuote();
        quote.setId(request.getId());
        quote.setFirstName(request.getFirstName());
        quote.setLastName(request.getLastName());
        quote.setCompanyName(request.getCompanyName());
        quote.setEmail(request.getEmail());
        quote.setPhoneNumber(request.getPhoneNumber());
        quote.setChooseQuoteType(request.getChooseQuoteType());
        quote.setMessage(request.getMessage());
        quote.setSelected(request.getSelected());
        quote.setUsed(request.isUsed());
        log.info("Inside addFreightQuote of FreightQuoteService");
        return freightQuoteRepository.save(quote);
    }

    @Override
    public FreightQuote updateFreightQuote(Long id, FreightQuoteRequest request) {
        FreightQuote quote = freightQuoteRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Resource not found with ID:"+id));
        quote.setId(request.getId());
        quote.setFirstName(request.getFirstName());
        quote.setLastName(request.getLastName());
        quote.setCompanyName(request.getCompanyName());
        quote.setEmail(request.getEmail());
        quote.setPhoneNumber(request.getPhoneNumber());
        quote.setChooseQuoteType(request.getChooseQuoteType());
        quote.setMessage(request.getMessage());
        quote.setSelected(request.getSelected());
        quote.setUsed(request.isUsed());
        log.info("Inside updateFreightQuote of FreightQuoteService");
        return freightQuoteRepository.save(quote);
    }

    @Override
    public List<FreightQuote> fetchAllFreightQuote() {
        return freightQuoteRepository.findAll();
    }

    @Override
    public FreightQuote fetchFreightQuote(Long id) {
        FreightQuote freightQuote = freightQuoteRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Resource not found with ID:"+id));
        return freightQuote;
    }

    @Override
    public void deleteFreightQuote(Long id) {
        FreightQuote freightQuote = freightQuoteRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Resource not found with ID:"+id));
        freightQuoteRepository.delete(freightQuote);
    }
}
