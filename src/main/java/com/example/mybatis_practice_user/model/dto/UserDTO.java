package com.example.mybatis_practice_user.model.dto;

import com.example.mybatis_practice_user.enumeration.UserStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class UserDTO {
    String username;

    String password;

    String email;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    public interface Update {}

    public interface Insert {}
}
