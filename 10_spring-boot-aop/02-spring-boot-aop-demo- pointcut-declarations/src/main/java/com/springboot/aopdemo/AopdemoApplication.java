package com.springboot.aopdemo;

import com.springboot.aopdemo.DAO.AccountDAO;
import com.springboot.aopdemo.DAO.MembershipDAO;
import com.springboot.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService)
	{
		return runner->{
			//demoBeforeAdvice(accountDAO, membershipDAO);
             // demoAftertReturningAdvice(accountDAO);
            //demoAfterThrowingAdvice(accountDAO);
			//demoAfterAdvice(accountDAO);
			// demoAroundAdvice(trafficFortuneService);
			 //demoAroundAdviceHandleException(trafficFortuneService);
		      demoAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program: demoAroundAdviceRethrowException");
		System.out.println("calling getFortune() method");
		boolean flag=true;
		String data=trafficFortuneService.getFortune(flag);
		System.out.println("Fortune is: "+ data);
	}

	private void demoAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program: demoAroundAdvice");
		System.out.println("calling getFortune() method");
		boolean flag=true;
		String data=trafficFortuneService.getFortune(flag);
		System.out.println("Fortune is: "+ data);
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program: demoAroundAdvice");
		System.out.println("calling getFortune() method");
		String data=trafficFortuneService.getFortune();
		System.out.println("Fortune is: "+ data);
	}

	private void demoAfterAdvice(AccountDAO accountDAO) {

        List<Account> theAccounts = null;
        try{
            //add boolean flag to simulate exception
            boolean flag=false;
            theAccounts=accountDAO.findAccounts(flag);
        }
        catch (Exception exc)
        {
            System.out.println("Main program:caught Exception.."+exc);
        }

        System.out.println("Main program:demoAfterAdvice");
        System.out.println("\n"+theAccounts);
    }

    private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> theAccounts = null;
		try{
			//add boolean flag to simulate exception
			boolean flag=true;
			theAccounts=accountDAO.findAccounts(flag);
		}
		catch (Exception exc)
		{
			System.out.println("Main program:caught Exception.."+exc);
		}

		System.out.println("Main program:demoAfterThrowingAdvice");
		System.out.println("\n"+theAccounts);
	}

	private void demoAftertReturningAdvice(AccountDAO accountDAO) {
		List<Account> theAccounts= accountDAO.findAccounts();

		System.out.println("Main program:demoAftertReturningAdvice");
		System.out.println("\n"+ theAccounts);
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account account=new Account();
		account.setName("Yashmi");
		account.setLevel("Platinum");
		accountDAO.addAccount(account,true);
		accountDAO.doWork();
		String name=accountDAO.getName();
		accountDAO.setName("Gow");
		String code=accountDAO.getServiceCode();
		accountDAO.setServiceCode("234");

		membershipDAO.addAccount();
		membershipDAO.goToSleep();
	}
}
