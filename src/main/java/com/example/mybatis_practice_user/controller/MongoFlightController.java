package com.example.mybatis_practice_user.controller;


import com.example.mybatis_practice_user.Service.MongoFlightService;
import com.example.mybatis_practice_user.model.dto.FlightDTO;
import com.example.mybatis_practice_user.model.entity.MongoFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mongoFlight")
public class MongoFlightController {
    private MongoFlightService mongoFlightService;

    @Autowired
    public MongoFlightController(MongoFlightService mongoFlightService)
    { this.mongoFlightService = mongoFlightService; }


    @GetMapping("/{flightId}")
    public MongoFlight getMongoFlightByFlightId(@PathVariable Integer flightId)
    { return mongoFlightService.getMongoFlightByFlightId(flightId); }

    @PutMapping("/addMongoFlight/{flightId}")
    public void addMongoFlight(@PathVariable Integer flightId) {
        mongoFlightService.addMongoFlight(flightId);
    }

    @PutMapping("/declineMongoFlight/{flightId}")
    public void declineMongoFlight(@PathVariable Integer flightId) {
        mongoFlightService.declineMongoFlight(flightId);
    }


}
