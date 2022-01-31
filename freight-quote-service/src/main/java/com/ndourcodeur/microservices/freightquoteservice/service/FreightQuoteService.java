package com.ndourcodeur.microservices.freightquoteservice.service;

import com.ndourcodeur.microservices.freightquoteservice.dto.FreightQuoteRequest;
import com.ndourcodeur.microservices.freightquoteservice.entity.FreightQuote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FreightQuoteService {

    public FreightQuote addFreightQuote(FreightQuoteRequest request);
    public FreightQuote updateFreightQuote(Long id, FreightQuoteRequest request);
    public List<FreightQuote> fetchAllFreightQuote();
    public FreightQuote fetchFreightQuote(Long id);
    public void deleteFreightQuote(Long id);
}
