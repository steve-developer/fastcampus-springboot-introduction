/*
package com.example.aop.aop;

import org.apache.commons.io.IOUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Aspect
@Configuration
public class TimerAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void pointCut(){}

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("----before ---");

        Object result = joinPoint.proceed();

        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
        System.out.println("-----after ----\n"+result);

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        final ContentCachingResponseWrapper res = (ContentCachingResponseWrapper) response;
        System.out.println(IOUtils.toString(res.getContentAsByteArray(),"UTF-8"));
    }
}*/
