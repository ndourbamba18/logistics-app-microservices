package com.ndourcodeur.microservices.freightquoteservice.repository;

import com.ndourcodeur.microservices.freightquoteservice.entity.FreightQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightQuoteRepository extends JpaRepository<FreightQuote, Long> {

}