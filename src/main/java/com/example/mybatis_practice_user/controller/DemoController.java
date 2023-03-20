package com.example.mybatis_practice_user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("demo")
    public String demoMethod()
    { return "Success!"; }
}
