package com.example.mybatis_practice_user.Service;

import com.example.mybatis_practice_user.model.dto.FlightDTO;
import com.example.mybatis_practice_user.model.dto.FlightSearchDTO;
import com.example.mybatis_practice_user.model.entity.Flight;

import java.util.List;

public interface FlightService {
    void addFlight(FlightDTO dto);

    Flight getFlightById(Integer id);

    Flight updateFlightById(FlightDTO dto,Integer id);

    void deleteFlightById(Integer id);

    List<Flight> searchFlight(FlightSearchDTO dto);
}
