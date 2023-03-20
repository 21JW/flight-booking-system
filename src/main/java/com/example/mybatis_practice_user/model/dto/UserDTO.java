package com.example.mybatis_practice_user.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    String username;

    String password;

    String email;

    public interface Update {}

    public interface Insert {}
}
