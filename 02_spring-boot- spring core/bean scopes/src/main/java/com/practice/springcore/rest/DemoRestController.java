package com.practice.springcore.rest;

import com.practice.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoRestController {

    private Coach coach;
    private Coach anothercoach;

    @Autowired
   public DemoRestController(@Qualifier("footballCoach") Coach thecoach,@Qualifier("footballCoach") Coach secondcoach) {
        System.out.println("In constructor:"+getClass().getSimpleName());
        coach=thecoach;
        anothercoach=secondcoach;
    }

    @GetMapping("/workout")
    public String detDailyWorkout()
    {
     return coach.detDailyWorkout();
    }
    @GetMapping("/check")
    public  String  comparison()
    {
        return "Comparison of coach==anothercoach"+ (coach==anothercoach);
    }

}
