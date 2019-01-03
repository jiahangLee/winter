package com.winter.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class HTTPAspect {

    @Pointcut(value = "execution(public * com.winter.demo.controller.GirlController.*(..))")
    public void log() {}

    @Before(value = "log()")
    public void log1(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
      log.info("我是好人AOP——before");
      log.info("url={}",request.getRequestURI());
      log.info("method={}",request.getMethod());
      log.info("ip={}",request.getRemoteAddr());
      log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
      log.info("args={}",joinPoint.getArgs());
    }

    @After(value = "log()")
    public void log2() {
        log.info("我是好人AOP——after");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doA(Object object) {
//        log.info("response={}", object.toString());
    }
}
