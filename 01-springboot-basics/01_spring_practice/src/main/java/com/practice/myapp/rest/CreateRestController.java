package com.practice.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateRestController {
    @GetMapping("/") public String sayHello()
{ return "Hello world!";
}
}
