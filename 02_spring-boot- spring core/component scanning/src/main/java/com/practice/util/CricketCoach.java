package com.practice.util;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String detDailyWorkout() {
        return" Practice for  bating 15 minutes";
    }
}

