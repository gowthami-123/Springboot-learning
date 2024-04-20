package com.practice.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach()
    {
        System.out.println("In constructor:"+ getClass().getSimpleName());
    }
    @Override
    public String detDailyWorkout() {
        return "Spend 1 hour for tennis ";
    }
}
