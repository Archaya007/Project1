package com.kgisl.flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.flight.entity.Flight;
import com.kgisl.flight.repository.FlightRepository;

@Service
public class FlightService{

@Autowired
private FlightRepository flightRepository;

public List<Flight> getAll(){
   return flightRepository.findAll();
}
public Optional<Flight> getById(int id){
   return flightRepository.findById(id);

}
public void delete(int id){
    flightRepository.deleteById(id);
}
public Flight create(Flight c){
   return flightRepository.save(c);
}
public Flight update(int id,Flight c){
   return flightRepository.save(c);
}

}