package com.example.mybatis_practice_user.Service;

import com.example.mybatis_practice_user.model.dto.FlightDTO;
import com.example.mybatis_practice_user.model.entity.MongoFlight;

public interface MongoFlightService {

    void saveMongoFlight(MongoFlight mongoFlight);
    MongoFlight getMongoFlightByFlightId(Integer flightId);
    void addMongoFlight(Integer courseId);
    void declineMongoFlight(Integer courseId);

}
