package com.example.mybatis_practice_user.Service.Impl;

import com.example.mybatis_practice_user.Service.UserService;
import com.example.mybatis_practice_user.mapper.UserMapper;
import com.example.mybatis_practice_user.model.dto.UserDTO;
import com.example.mybatis_practice_user.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void addUser(UserDTO dto) {
        User user=new User(dto);
        userMapper.insert(user);
    }
}

