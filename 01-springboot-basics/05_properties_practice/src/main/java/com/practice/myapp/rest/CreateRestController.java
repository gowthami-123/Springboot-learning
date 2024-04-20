package com.practice.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateRestController {

    @Value("${team.name}")
    private String teamname;
    @Value("${coach.name}")
    private String coachname;
    @GetMapping("/teaminfo")
    public String teaminfo()
    {
        return "Teamname:"+ teamname + "   Coachname:" +coachname;
    }

    @GetMapping("/") public String sayHello()
{ return "Hello world!";
}
    @GetMapping("/newpage")
    public String printMessage()
    {
        return "This is dev tool practice";
    }
}
