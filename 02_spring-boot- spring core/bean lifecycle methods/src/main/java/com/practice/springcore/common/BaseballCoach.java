package com.practice.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach()
    {
        System.out.println("In constructor:"+ getClass().getSimpleName());
    }

    //init method
    @PostConstruct
    public void startUpStuff(){
        System.out.println("In Init method"+getClass().getSimpleName() );
    }

    //destroy method

    @PreDestroy
    public void cleanUpStuff()
    {
        System.out.println("In destroy method"+getClass().getSimpleName());
    }

    @Override
    public String detDailyWorkout() {
        return  "Spend 30 minutes daily in bating";
    }
}
