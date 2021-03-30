/*
package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Aspect
@Configuration
public class LogAop {

    @Pointcut("@annotation(com.example.aop.annotation.Logger)")
    private void enableLogger(){}

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void pointCut(){}

    @Before("pointCut() && enableLogger()")
    private void before(JoinPoint joinPoint) throws IOException {
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
            System.out.println("Input Arg: "+signatureArg.getClass().getSimpleName()+" "+ signatureArg);
        }
    }

    @AfterReturning(value = "pointCut() && enableLogger()", returning = "returnObject")
    private void afterRetring(JoinPoint joinPoint, Object returnObject){
        System.out.println("returning arg: " + returnObject);
    }
}*/
