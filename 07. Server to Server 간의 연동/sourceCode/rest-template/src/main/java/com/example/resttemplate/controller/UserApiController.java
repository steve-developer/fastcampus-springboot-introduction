package com.example.resttemplate.controller;

import com.example.resttemplate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @GetMapping("")
    public void get(){
        userService.naver();
    }

}
