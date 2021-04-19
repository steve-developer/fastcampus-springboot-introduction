package com.example.filterandinterceptor.controller;

import com.example.filterandinterceptor.annotation.AuthUser;
import com.example.filterandinterceptor.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AuthUser
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/post")
    public User post(@RequestBody User user){
        return user;
    }

    @DeleteMapping("/delete")
    public ResponseEntity post(){
        return ResponseEntity.ok().build();
    }
}
