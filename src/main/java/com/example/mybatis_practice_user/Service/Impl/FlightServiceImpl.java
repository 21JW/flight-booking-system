package com.example.mybatis_practice_user.Service.Impl;

import com.example.mybatis_practice_user.Service.FlightService;
import com.example.mybatis_practice_user.mapper.FlightMapper;
import com.example.mybatis_practice_user.model.dto.FlightDTO;
import com.example.mybatis_practice_user.model.entity.Flight;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightMapper flightMapper;

    @Override
    public void addFlight(FlightDTO dto){
        Flight flight=new Flight(dto);
        flight.setCreateTime(new Date());
        flight.setTs(new Date());
        flightMapper.insert(flight);
    }
}
