package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class CloudLogAsyncAspect {
    @Before("com.springboot.aopdemo.aspect.AopExpressions.packageExcludeGetSet()")
    public  void performCloudAnalytics()
    {
        System.out.println("--->Performing Cloud Async Analytics --->");
    }
}
