package com.example.mybatis_practice_user.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserFlightResponse {
    Integer id;
    String username;
    String flightName;

    public interface Update {}

    public interface Insert {}

}
