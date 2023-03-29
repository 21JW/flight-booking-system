package com.example.mybatis_practice_user.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class FlightDTO {
    private String company;

    private String flightName;

    private String departure;

    private String destination;

    private Integer price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Toronto")
    private Date departTime;


    public interface Update {}

    public interface Insert {}
}
