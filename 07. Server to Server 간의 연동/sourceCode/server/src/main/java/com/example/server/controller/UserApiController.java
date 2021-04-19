package com.example.server.controller;

import com.example.server.dto.Car;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping("")
    public User get(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        user.setCarList(Arrays.asList(
                new Car("K5","11가 1111"),
                new Car("A4","22나 2222"),
                new Car("BMW","33가 3333")
        ));

        return user;
    }

    @PostMapping("")
    public User post(@RequestBody User user){
        return user;
    }

    @PostMapping("header")
    public User header(@RequestHeader(value = "x-authorization") String header, @RequestBody User user){
        log.info("header : {}",header);
        log.info("body : {}", user);
        return user;
    }
}
