package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.JobImpressions;
import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAdvice {

    //setup logger
    private Logger myLogger= Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forController(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forService(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDao(){}

    @Pointcut("forController() || forService() || forDao()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint)
    {
        //display method
        String method=theJoinPoint.getSignature().toShortString();
        myLogger.info("--->in @Before: Method: "+ method);

        //display arguments to the method
        Object[] args=theJoinPoint.getArgs();
        for(Object tempArg:args)
        {
            myLogger.info("argument: "+ tempArg);
        }
    }

    @AfterReturning(
            pointcut ="forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint theJoinPoint, Object result)
    {
        //display method
        String method=theJoinPoint.getSignature().toShortString();
        myLogger.info("--->in @AfterReturning: Method: "+ method);

        //display the data returned
        myLogger.info("-->Result: "+ result);


    }


}
