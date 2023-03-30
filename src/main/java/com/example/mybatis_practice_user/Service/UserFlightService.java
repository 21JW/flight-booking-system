package com.example.mybatis_practice_user.Service;

import com.example.mybatis_practice_user.model.dto.UserFlightDTO;
import com.example.mybatis_practice_user.model.vo.UserFlightResponse;

import java.util.List;

public interface UserFlightService {
    void addUserFlight(UserFlightDTO dto);

    void deleteUserFlight(Integer userId,Integer flightId);

    List<UserFlightResponse> findAllUserFlightResponse();


}
