package com.example.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class TaskService {

    @Resource(name = "asyncThread")
    private Executor executor;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async("asyncThread")
    public void run(int i) {
        logger.info("count : {}",i);
    }

    @Async("asyncThread")
    public ListenableFuture<Integer> listenableFuture(int i) throws InterruptedException {
        Thread.sleep(1000);
        logger.info("----------------");
        return new AsyncResult<>(i);
    }

    @Async("asyncThread")
    public CompletableFuture<String> completableFuture(int i) throws InterruptedException {
        /*CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()-> hello(),executor);
        completableFuture.thenApplyAsync(s -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("completable : {}",s);
            return "completable";
        },executor);*/

        return new AsyncResult<String>(hello()).completable();
    }

    public String hello() {
        logger.info("hello Method Call");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hellosss";
    }
}
