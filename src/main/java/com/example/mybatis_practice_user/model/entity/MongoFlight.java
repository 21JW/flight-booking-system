package com.example.mybatis_practice_user.model.entity;


import com.example.mybatis_practice_user.model.dto.FlightDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "mongo_flight")
@NoArgsConstructor
public class MongoFlight {
    private Integer flightId;
    private Integer capacity;
    private Integer available;

    public MongoFlight(Integer flightId,Integer capacity,Integer available) {
        this.flightId=flightId;
        this.capacity=capacity;
        this.available=available;
    }


}
