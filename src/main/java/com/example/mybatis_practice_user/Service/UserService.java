package com.example.mybatis_practice_user.Service;

import com.example.mybatis_practice_user.model.dto.UserDTO;
import com.example.mybatis_practice_user.model.entity.User;

public interface UserService {
    void addUser(UserDTO dto);

    void deleteUserById(Integer id);


}
