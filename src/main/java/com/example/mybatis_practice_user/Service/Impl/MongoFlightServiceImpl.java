package com.example.mybatis_practice_user.Service.Impl;


import com.example.mybatis_practice_user.Service.MongoFlightService;
import com.example.mybatis_practice_user.model.dto.FlightDTO;
import com.example.mybatis_practice_user.model.entity.MongoFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Transactional
@Service
public class MongoFlightServiceImpl implements MongoFlightService {
    private MongoTemplate mongoTemplate;

    @Autowired
    public MongoFlightServiceImpl(MongoTemplate mongoTemplate)
    { this.mongoTemplate = mongoTemplate; }

    @Override
    public void saveMongoFlight(MongoFlight mongoFlight){
        Query query = Query.query(Criteria.where("flightId").is(mongoFlight.getFlightId()));
        Update update = new Update();
        update.set("capacity", mongoFlight.getCapacity());
        update.set("available", mongoFlight.getAvailable());
        mongoTemplate.updateFirst(query, update, MongoFlight.class);
    }

    @Override
    public MongoFlight getMongoFlightByFlightId(Integer flightId){
        Query query = Query.query(Criteria.where("flightId").is(flightId));
        List<MongoFlight> mongoFlight = mongoTemplate.find(query, MongoFlight.class);

        if(mongoFlight.size() == 0)
        { return null; }

        return mongoFlight.get(0);
    }
    @Override
    public void addMongoFlight(Integer flightId){
        MongoFlight mongoFlight = getMongoFlightByFlightId(flightId);

        if (mongoFlight != null)
        {
            Integer available = mongoFlight.getAvailable();
            if(available<=0)
            {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "this flight is not available");
            }
            else
            {
                available=available-1;
                mongoFlight.setAvailable(available);
                saveMongoFlight(mongoFlight);
            }
        }
    }
    @Override
    public void declineMongoFlight(Integer flightId)
    {
        MongoFlight mongoFlight = getMongoFlightByFlightId(flightId);

        if (mongoFlight != null)
        {
            Integer available = mongoFlight.getAvailable();
            Integer capacity = mongoFlight.getCapacity();
            if(available<capacity)
            {
                available=available+1;
                mongoFlight.setAvailable(available);
                saveMongoFlight(mongoFlight);
            }
        }
    }
}
