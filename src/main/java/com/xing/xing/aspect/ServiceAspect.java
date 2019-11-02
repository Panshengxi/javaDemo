package com.xing.xing.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class ServiceAspect {
    private final static Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

    //定义一个公用方法
    @Pointcut("execution(public * com.xing.xing.service.*.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("args={}",joinPoint.getArgs());
    }


}
