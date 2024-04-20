package com.springboot.thymeleafpractice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showform")
    public String showForm()
    {
       return "helloworld-form";
    }
 @RequestMapping("/processform")
    public String processForm()
 {
     return "helloworld";
 }
 @RequestMapping("/processformversiontwo")
    public  String letShotDude(HttpServletRequest request, Model theModel)
 {
    String name=request.getParameter("Studentname");
    name=name.toUpperCase();
    name="Hi"+name;
    theModel.addAttribute("message",name);
    return "helloworld";
 }

    @RequestMapping("/processformversionthree")
    public  String letShotDude(@RequestParam("Studentname") String name, Model theModel)
    {
        name=name.toUpperCase();
        name="Hey  "+name;
        theModel.addAttribute("message",name);
        return "helloworld";
    }


}
