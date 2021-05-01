package com.example.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {

    @ApiModelProperty(value = "사용자 이름", example = "steve")
    private String name;


    @ApiModelProperty(value = "사용자 나이", example = "10")
    private int age;
}
