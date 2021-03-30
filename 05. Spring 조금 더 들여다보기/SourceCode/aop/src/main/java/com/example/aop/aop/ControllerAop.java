package com.example.aop.aop;

import org.apache.commons.io.IOUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Aspect
@Configuration
public class ControllerAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void pointCut(){}

    @Before("pointCut()")
    private void before(JoinPoint joinPoint) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        final ContentCachingRequestWrapper cachingReq = (ContentCachingRequestWrapper) request;
        System.out.println(IOUtils.toString(cachingReq.getContentAsByteArray(),"UTF-8"));
    }

    @After("pointCut()")
    private void after(JoinPoint joinPoint) throws IOException {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
    }
}
