package com.practice.springcore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    public FootballCoach()
    {
        System.out.println("In constructor:"+ getClass().getSimpleName());
    }
    @Override
    public String detDailyWorkout() {
        return "Spend 2 hours for football";
    }
}
