package com.example.mybatis_practice_user.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "mongo_flight")
@NoArgsConstructor
public class MongoFlight {
    private Integer flightId;
    private Integer capacity;
    private Integer available;


}
