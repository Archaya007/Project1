package com.kgisl.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.flight.entity.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer>{
    
}
