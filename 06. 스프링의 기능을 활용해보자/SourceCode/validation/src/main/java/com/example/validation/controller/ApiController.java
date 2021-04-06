package com.example.validation.controller;

import com.example.validation.dto.Req;
import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

    @GetMapping("")
    public String get(
    /*        @Size(min = 1 , max = 10)
            @NotEmpty
            @RequestParam String name,

            @Min(10)
            @RequestParam int age

    */
        @Valid Req req
    ){
        return req.getName() + req.getAge();
    }

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field : "+field.getField());
                System.out.println(message);

                sb.append("field : "+field.getField());
                sb.append("message : "+message);

            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }


        return ResponseEntity.ok(user);
    }

}
