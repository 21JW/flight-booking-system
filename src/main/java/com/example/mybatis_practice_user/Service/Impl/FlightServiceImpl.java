package com.example.mybatis_practice_user.Service.Impl;

import com.example.mybatis_practice_user.Service.FlightService;
import com.example.mybatis_practice_user.mapper.FlightMapper;
import com.example.mybatis_practice_user.model.dto.FlightDTO;
import com.example.mybatis_practice_user.model.dto.FlightSearchDTO;
import com.example.mybatis_practice_user.model.entity.Flight;
import com.example.mybatis_practice_user.model.entity.MongoFlight;
import com.example.mybatis_practice_user.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightMapper flightMapper;
    @Autowired
    private MongoTemplate mongoTemplate;

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
        // MongoDB add Flight
        MongoFlight mongoFlight=new MongoFlight(flight.getId(), dto.getCapacity(), dto.getAvailable());
        mongoFlight = mongoTemplate.insert(mongoFlight);
        Query query = Query.query(Criteria.where("flightId").is(mongoFlight.getFlightId()));
        Update update = new Update();
        update.set("capacity", dto.getCapacity());
        update.set("available", dto.getAvailable());
        mongoTemplate.updateFirst(query, update, MongoFlight.class);
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

    @Override
    public void deleteFlightById(Integer id){
        Flight flight = flightMapper.findFlightById(id);
        if(flight==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        flightMapper.deleteById(id);
    }

    @Override
    public List<Flight> searchFlight(FlightSearchDTO dto){
        List<Flight> result=flightMapper.findFlight(dto.getDeparture(), dto.getDestination(),dto.getStartTime(),dto.getEndTime());
        return result;
    }

    @Override
    public List<Flight> searchFlightByParams(FlightSearchDTO dto){
        return flightMapper.searchFlightByParams(dto);
    }

}
