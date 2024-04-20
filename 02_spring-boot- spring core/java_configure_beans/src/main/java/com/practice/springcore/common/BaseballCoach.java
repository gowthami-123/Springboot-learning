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


    @Override
    public String detDailyWorkout() {
        return  "Spend 30 minutes daily in bating";
    }
}
