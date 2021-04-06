package com.example.async.controller;

import com.example.async.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TaskService taskService;

    @GetMapping("/hello")
    public String hello() {
        logger.info("Thread Start");

        for(int i = 0 ; i < 10; i ++){
            //async(i);
            taskService.run(i);
        }

        logger.info("Thread end");
        return "response hello";
    }

    @GetMapping("/future")
    public ListenableFuture<Integer> listenableFuture() throws InterruptedException, ExecutionException {
        logger.info("future Start");
        logger.info("future end");
        return taskService.listenableFuture(10000);
    }

    @GetMapping("/completableFuture")
    public CompletableFuture<String> completableFuture() throws Exception {
        logger.info("completableFuture Start");
        logger.info("completableFuture end");
        return taskService.completableFuture(1000);
    }

    @Async
    public void async(int i){
        logger.info("in method : {}",i);

    }
}
