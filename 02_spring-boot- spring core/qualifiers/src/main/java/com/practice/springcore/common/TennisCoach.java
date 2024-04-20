package com.practice.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String detDailyWorkout() {
        return "Spend 1 hour for tennis ";
    }
}
