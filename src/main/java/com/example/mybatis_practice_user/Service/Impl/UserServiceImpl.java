package com.example.mybatis_practice_user.Service.Impl;

import com.example.mybatis_practice_user.Service.UserService;
import com.example.mybatis_practice_user.mapper.UserMapper;
import com.example.mybatis_practice_user.model.dto.UserDTO;
import com.example.mybatis_practice_user.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void addUser(UserDTO dto) {
        User user=new User(dto);
        user.setCreateTime(new Date());
        user.setTs(new Date());
        userMapper.insert(user);
    }

    @Override
    public void deleteUserById(Integer id){
        //User user=userMapper.findById(id);
        userMapper.deleteById(id);
    }
}

