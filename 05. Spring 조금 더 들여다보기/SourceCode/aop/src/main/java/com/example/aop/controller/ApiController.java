package com.example.aop.controller;

import com.example.aop.annotation.Logger;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam Map<String,Object> parameter){
        return parameter.toString();
    }

    @Logger
    @PostMapping("/post")
    public User post(@RequestBody User user){
        return user;
    }
}
