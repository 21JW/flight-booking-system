package com.example.mybatis_practice_user.controller;

import com.example.mybatis_practice_user.Service.UserFlightService;
import com.example.mybatis_practice_user.model.dto.UserFlightDTO;
import com.example.mybatis_practice_user.model.vo.UserFlightResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userFlight")
public class UserFlightController {
    @Autowired
    private UserFlightService userFlightService;

    @PostMapping
    public void addUserFlight(@RequestBody UserFlightDTO dto) {
        userFlightService.addUserFlight(dto);
    }

    @GetMapping
    public List<UserFlightResponse> getAllUserFlightResponse(){
        return userFlightService.findAllUserFlightResponse();
    }

}
