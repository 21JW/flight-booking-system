package com.example.mybatis_practice_user.Service.Impl;

import com.example.mybatis_practice_user.Service.FlightService;
import com.example.mybatis_practice_user.Service.UserFlightService;
import com.example.mybatis_practice_user.Service.UserService;
import com.example.mybatis_practice_user.mapper.UserFlightMapper;
import com.example.mybatis_practice_user.model.dto.UserFlightDTO;
import com.example.mybatis_practice_user.model.vo.UserFlightResponse;
import com.example.mybatis_practice_user.model.entity.UserFlight;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserFlightServiceImpl implements UserFlightService {
    private UserFlightMapper userFlightMapper;
    private UserService userService;
    private FlightService flightService;

    @Autowired
    public UserFlightServiceImpl(UserFlightMapper userFlightMapper, UserService userService, FlightService flightService) {
        this.userFlightMapper = userFlightMapper;
        this.userService = userService;
        this.flightService = flightService;
    }

    @Override
    public void addUserFlight(UserFlightDTO dto){

        Integer userId = dto.getUserId();
        Integer flightId=dto.getFlightId();

        userService.getUserById(userId);
        flightService.getFlightById(flightId);

        UserFlight existingRecord = userFlightMapper.findByUserIdANDFlightId(userId, flightId);
        if(existingRecord != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "this flight has been chosen");
        }

        UserFlight userFlight = new UserFlight(dto);

        userFlight.setCreateTime(new Date());
        userFlight.setTs(new Date());

        userFlightMapper.insert(userFlight);

    }

    @Override
    public List<UserFlightResponse> findAllUserFlightResponse() {
        return userFlightMapper.findUserFlightResponse();
    }


}
