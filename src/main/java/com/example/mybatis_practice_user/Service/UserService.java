package com.example.mybatis_practice_user.Service;

import com.example.mybatis_practice_user.model.dto.IdListDTO;
import com.example.mybatis_practice_user.model.dto.UserDTO;
import com.example.mybatis_practice_user.model.entity.User;

import java.util.List;

public interface UserService {
    void addUser(UserDTO dto);

    void deleteUserById(Integer id);

    User getUserById(Integer id);

    User updateUserById(UserDTO dto,Integer id);

    User getUserByEmail(String email);

    List<User> findUserByIdList(IdListDTO dto);


}
