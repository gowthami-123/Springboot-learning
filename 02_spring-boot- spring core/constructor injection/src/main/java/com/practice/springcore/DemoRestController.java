package com.practice.springcore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoRestController {

    private Coach coach;

   public DemoRestController(Coach thecoach){
        coach=thecoach;
    }
    @GetMapping("/workout")
    public String detDailyWorkout()
    {
     return coach.detDailyWorkout();
    }

}
