package com.practice.springcore.rest;

import com.practice.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoRestController {

    private Coach coach;

    @Autowired
   public DemoRestController(Coach thecoach) {
        coach=thecoach;
    }

    @GetMapping("/workout")
    public String detDailyWorkout()
    {
     return coach.detDailyWorkout();
    }

}
