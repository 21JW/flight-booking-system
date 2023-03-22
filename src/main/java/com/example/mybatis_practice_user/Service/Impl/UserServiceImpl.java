package com.example.mybatis_practice_user.Service.Impl;

import com.example.mybatis_practice_user.Service.UserService;
import com.example.mybatis_practice_user.mapper.UserMapper;
import com.example.mybatis_practice_user.model.dto.IdListDTO;
import com.example.mybatis_practice_user.model.dto.UserDTO;
import com.example.mybatis_practice_user.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

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
        User user = userMapper.findById(id);
        if(user==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        userMapper.deleteById(id);
    }

    @Override
    public User getUserById(Integer id){
        User user = userMapper.findById(id);
        if(user==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }

    @Override
    public User updateUserById(UserDTO dto, Integer id) {
        User user = getUserById(id);
        BeanUtils.copyProperties(dto, user);
        user.setTs(new Date());
        userMapper.updateById(user);
        return user;
    }

    @Override
    public User getUserByEmail(String email){
        User user = userMapper.findByEmail(email);
        if(user==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }
    @Override
    public List<User> findUserByIdList(IdListDTO dto){
        List<User> response = userMapper.findByIdList(dto.getIds());
        return response;
    }
}

