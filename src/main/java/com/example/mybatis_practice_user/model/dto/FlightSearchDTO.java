package com.example.mybatis_practice_user.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class FlightSearchDTO {
    private String departure;

    private String destination;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Toronto")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Toronto")
    private Date endTime;
}
