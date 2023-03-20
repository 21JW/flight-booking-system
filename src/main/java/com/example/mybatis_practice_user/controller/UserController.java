package com.example.mybatis_practice_user.controller;
import com.example.mybatis_practice_user.Service.UserService;
import com.example.mybatis_practice_user.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> Register(@RequestBody @Validated(UserDTO.Insert.class) UserDTO dto) {
        userService.addUser(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
