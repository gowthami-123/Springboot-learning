package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
    @Before("execution(* com.springboot.aopdemo.DAO..*.*(..))")
    public void beforeAddAccountAdvice()
    {
        System.out.println("-->Executing @Before advice method--->");
    }

}
