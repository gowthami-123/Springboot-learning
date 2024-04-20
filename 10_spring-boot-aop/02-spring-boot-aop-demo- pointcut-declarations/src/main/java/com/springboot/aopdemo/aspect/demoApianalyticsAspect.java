package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class demoApianalyticsAspect {

    @Before("com.springboot.aopdemo.aspect.AopExpressions.packageExcludeGetSet()")
    public  void performApiAnalytics()
    {
        System.out.println("--->Performing API Analytics --->");
    }
}
