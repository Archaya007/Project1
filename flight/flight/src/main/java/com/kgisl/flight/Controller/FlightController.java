package com.kgisl.flight.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.flight.entity.Flight;
import com.kgisl.flight.service.FlightService;
@RestController
@RequestMapping("/flight")
@CrossOrigin("*")
public class FlightController {
    @Autowired
    private FlightService flightService;
   
    @GetMapping("/")
    public ResponseEntity<List<Flight>> getFlight() {
        List<Flight> l = flightService.getAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Flight>> getFlightById(@PathVariable int id) {
        Optional<Flight> l = flightService.getById(id);
        return new ResponseEntity<>(l, HttpStatus.FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Flight> insertFlight(@RequestBody Flight c){
        Flight l = flightService.create(c);
        return new ResponseEntity<>(l, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFlightById(@PathVariable int id){
        flightService.delete(id);
       return new ResponseEntity<>(HttpStatus.GONE);
    }
   
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable int id,@RequestBody Flight flight){
        Flight l = flightService.update(id, flight);
      return new ResponseEntity<>(l, HttpStatus.ACCEPTED);
    
    }
}
