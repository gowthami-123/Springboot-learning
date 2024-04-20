package com.practice.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach{
    @Override
    public String detDailyWorkout() {
        return  "Spend 30 minutes daily in bating";
    }
}
