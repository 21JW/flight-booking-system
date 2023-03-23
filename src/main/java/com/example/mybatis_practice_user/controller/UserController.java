package com.example.mybatis_practice_user.controller;
import com.example.mybatis_practice_user.Service.UserService;
import com.example.mybatis_practice_user.model.dto.IdListDTO;
import com.example.mybatis_practice_user.model.dto.UserDTO;
import com.example.mybatis_practice_user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> Register(@RequestBody @Validated(UserDTO.Insert.class) UserDTO dto) {
        userService.addUser(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id)
    {
        userService.deleteUserById(id);
    }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable Integer id)
    {
        User user=userService.getUserById(id);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody @Validated(UserDTO.Update.class) UserDTO dto, @PathVariable Integer id) {
        User user = userService.updateUserById(dto, id);
        return user;
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email)
    {
        User user=userService.getUserByEmail(email);
        return user;
    }

    @GetMapping("/ids")
    public List<User> findUsersByIds(@RequestBody IdListDTO dto) {
        List<User> response=userService.findUserByIdList(dto);
        return response;
    }
}
