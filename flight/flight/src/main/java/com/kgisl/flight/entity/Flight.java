package com.kgisl.flight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String firstname;
     String lastname ;
     String email;
     String dob;
     String gender;
    String  departuredate;
     String destinationdate;
    String locations ;
    String classes;
    String  insurancepolicies;


    // public Flight() {
    // }


    // public Flight(String firstname, String lastname, String email, String dob, String gender, String departuredate,
    //         String destinationdate, String locations, String classes, String insurancepolicies) {
    //     this.firstname = firstname;
    //     this.lastname = lastname;
    //     this.email = email;
    //     this.dob = dob;
    //     this.gender = gender;
    //     this.departuredate = departuredate;
    //     this.destinationdate = destinationdate;
    //     this.locations = locations;
    //     this.classes = classes;
    //     this.insurancepolicies = insurancepolicies;
    // }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getdeparturedate() {
        return departuredate;
    }
    public void setdeparturedate(String departuredate) {
        this.departuredate = departuredate;
    }
    public String getdestinationdate() {
        return destinationdate;
    }
    public void setdestinationdate(String destinationdate) {
        this.destinationdate = destinationdate;
    }
   
    public String getLocations() {
        return locations;
    }
    public void setLocations(String locations) {
        this.locations = locations;
    }
    public String getClasses() {
        return classes;
    }
    
    public void setClasses(String Classes) {
        this.classes = classes;
    }
    public String getInsurancepolicies() {
        return insurancepolicies;
    }
    public void setInsurancepolicies(String insurancepolicies) {
        this.insurancepolicies = insurancepolicies;
    }
    @Override
    public String toString() {
        return "Flight [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
                + ", dob=" + dob + ", gender=" + gender + ", departuredate=" + departuredate + ", destinationdate="
                + destinationdate + ", locations=" + locations + ", classes=" + classes + ", insurancepolicies="
                + insurancepolicies + "]";
    }
    
   

    
}
