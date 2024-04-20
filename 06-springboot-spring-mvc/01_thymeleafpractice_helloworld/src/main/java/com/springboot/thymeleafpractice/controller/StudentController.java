package com.springboot.thymeleafpractice.controller;

import com.springboot.thymeleafpractice.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;

@Controller
public class StudentController {

    //inject countries from application.properties

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${operatingsystems}")
    private  List<String> operatingsystems;

    @GetMapping("/showstudentform")
    public String showForm(Model theModel){
        //create a student object
        Student theStudent=new Student();

        //add student object to the model
        theModel.addAttribute("student",theStudent);

        //add the list of countries to the model
        theModel.addAttribute("countries",countries);
        theModel.addAttribute("languages",languages);
        theModel.addAttribute("systems",operatingsystems);

        return "student-form";
    }

    @PostMapping("/processstudentform")
    public String processForm(@ModelAttribute("student") Student theStudennt)
    {
       //log the input data
        System.out.println("theStudent:  "+ theStudennt.getFirstName() +" ," + theStudennt.getLastName());

        return "student-confirmation";
    }
}
