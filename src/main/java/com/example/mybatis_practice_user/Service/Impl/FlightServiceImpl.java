package com.example.mybatis_practice_user.Service.Impl;

import com.example.mybatis_practice_user.Service.FlightService;
import com.example.mybatis_practice_user.mapper.FlightMapper;
import com.example.mybatis_practice_user.model.dto.FlightDTO;
import com.example.mybatis_practice_user.model.entity.Flight;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
@Slf4j
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightMapper flightMapper;

    @Override
    public void addFlight(FlightDTO dto){
        if(flightMapper.findByFlightNameANDDepartTime(dto.getFlightName(),dto.getDepartTime())!=null)
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "flight has been registered");
        }
        Flight flight=new Flight(dto);
        flight.setCreateTime(new Date());
        flight.setTs(new Date());
        flightMapper.insert(flight);
    }

    @Override
    public Flight getFlightById(Integer id)
    {
        Flight flight=flightMapper.findFlightById(id);
        if(flight==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "flight not found");
        }
        return flight;
    }

    @Override
    public Flight updateFlightById(FlightDTO dto,Integer id){
        Flight flight=flightMapper.findFlightById(id);
        BeanUtils.copyProperties(dto, flight);
        flight.setTs(new Date());
        flightMapper.updateById(flight);
        return flight;
    }

}
