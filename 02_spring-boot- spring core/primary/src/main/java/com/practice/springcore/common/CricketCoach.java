package com.practice.springcore.common;

import com.practice.springcore.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String detDailyWorkout() {
        return" Practice for  bating 15 minutes";
    }
}

