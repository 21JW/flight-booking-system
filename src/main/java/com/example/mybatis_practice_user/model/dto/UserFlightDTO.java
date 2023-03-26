package com.example.mybatis_practice_user.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserFlightDTO {

    Integer userId;

    Integer flightId;

    public interface Update {}

    public interface Insert {}
}
