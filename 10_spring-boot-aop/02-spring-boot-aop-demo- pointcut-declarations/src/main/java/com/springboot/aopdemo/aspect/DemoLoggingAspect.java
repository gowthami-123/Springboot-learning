package com.springboot.aopdemo.aspect;

import com.springboot.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(-3)
public class DemoLoggingAspect {

    @Before("com.springboot.aopdemo.aspect.AopExpressions.packageExcludeGetSet()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("-->Executing @Before advice method--->");

        //display method signature
        MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+ methodSignature);

        //display method arguments

        Object[] args=theJoinPoint.getArgs();
        for(Object temparg: args)
        {
            System.out.println(temparg);

            if(temparg instanceof Account)
            {
                //downcast and print account specific stuff
                Account theAccount=(Account) temparg;
                System.out.println("Account name: "+ theAccount.getName());
                System.out.println("Account level: "+ theAccount.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.springboot.aopdemo.DAO.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result)
    {
      //print out the method
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n--->Executing @AfterReturning on method :"+method);

        //print out results
        System.out.println("-->Result is  "+ result);

        //post-processing the result data
        covertAccountNameToUpperCase(result);

        System.out.println("-->After update Result is  "+ result);
    }

    private void covertAccountNameToUpperCase(List<Account> result) {
        for(Account tempAccount:result)
        {
            String upperName= tempAccount.getName().toUpperCase();
            tempAccount.setName(upperName);
        }
    }

    @AfterThrowing(
            pointcut ="execution(* com.springboot.aopdemo.DAO.AccountDAO.findAccounts(..))" ,
            throwing ="theExc"
    )
    private void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Exception theExc){
        //print out the method
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n--->Executing @AfterThrowing on method :"+method);

        System.out.println("\n--->Exception is:"+theExc);

    }


    @After("execution(* com.springboot.aopdemo.DAO.AccountDAO.findAccounts(..))")
    private void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        //print out the method
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n--->Executing @After on method :"+method);


    }

    @Around("execution(* com.springboot.aopdemo.service.*.getFortune(..))")
    public  Object afterGetFortune(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        //print out the method
        String method=proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n--->Executing @Around on method :"+method);
        //begin timestamp
        long begin=System.currentTimeMillis();
        //execute the method
        Object result=null;
        try{
            result=proceedingJoinPoint.proceed();
        }
        catch (Exception exc)
        {
            System.out.println(exc.getMessage());
            //rethrow exception
            throw exc;
        }
        //end timestamp
        long end=System.currentTimeMillis();
        long duration= end- begin;
        System.out.println("-->Duration :"+ duration/1000.0+" seconds");

        return result;

    }

}
