package com.example.mybatis_practice_user.controller;


import com.example.mybatis_practice_user.Service.MongoFlightService;
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

    @PostMapping()
    public void saveMongoFlight(@RequestBody MongoFlight mongoFlight)
    { mongoFlightService.saveFlight(mongoFlight); }

    @GetMapping("/{flightId}")
    public MongoFlight getMongoFlightByFlightId(@PathVariable Integer flightId)
    { return mongoFlightService.getMongoFlightByFlightId(flightId); }

    @PutMapping("/addMongoFlight/{flightId}")
    public void addMongoFlight(@PathVariable Integer flightId) {
        mongoFlightService.addMongoFlight(flightId);
    }


}
