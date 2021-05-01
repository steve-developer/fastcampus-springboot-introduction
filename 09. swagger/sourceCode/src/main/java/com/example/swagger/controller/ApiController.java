package com.example.swagger.controller;

import com.example.swagger.dto.UserRequest;
import com.example.swagger.dto.UserResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"REST API CONTROLLER"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @ApiOperation(value = "hello method", notes = "기본적인 인사 GET API")
/*    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "사용자 이름", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "age", value = "사용자 나이", required = true, dataType = "int", paramType = "query")
    })*/
    @GetMapping("/hello/{name}")
    public String hello(
            @ApiParam(value = "사용자 이름")
            @PathVariable String name,

            @ApiParam(value = "사용자 나이")
            @RequestParam int age){
        return "hello";
    }

    @GetMapping("/user")
    public UserResponse user(UserRequest userRequest){
        return new UserResponse(userRequest.getName(), userRequest.getAge());
    }

    @PostMapping("/user")
    @ApiResponse(code = 404, message = "not found")
    public UserResponse post(@RequestBody UserRequest userRequest){
        return new UserResponse(userRequest.getName(), userRequest.getAge());
    }
}
