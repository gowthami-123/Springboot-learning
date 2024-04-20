package com.springboot.aopdemo.service;

import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {
        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException exception)
        {
            throw new RuntimeException(exception);
        }

        //return fortune
        return "Except heavy traffic in the morning";
    }

    @Override
    public String getFortune(boolean flag) {
        if(flag){
            throw new RuntimeException("Majpr accident! Highway is closed");
        }
        return getFortune();
    }
}
