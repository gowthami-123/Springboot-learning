package com.practice.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String detDailyWorkout() {
        return "Spend 2 hours for football";
    }
}
