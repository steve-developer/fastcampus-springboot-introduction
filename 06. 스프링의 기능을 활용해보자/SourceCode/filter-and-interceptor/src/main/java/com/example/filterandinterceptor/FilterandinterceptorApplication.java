package com.example.filterandinterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FilterandinterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterandinterceptorApplication.class, args);
    }

}
