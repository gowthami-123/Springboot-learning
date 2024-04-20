package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {
    @Pointcut("execution(* com.springboot.aopdemo.DAO.*.*(..))")
    public   void forDaoPackage(){}
    //create point to getter methods
    @Pointcut("execution(* com.springboot.aopdemo.DAO.*.get*(..))")
    public   void getter(){}

    //create pointcut to setter methods
    @Pointcut("execution(* com.springboot.aopdemo.DAO.*.set*(..))")
    public  void setter(){}

    //create pointcut to package..exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void packageExcludeGetSet(){}
}
