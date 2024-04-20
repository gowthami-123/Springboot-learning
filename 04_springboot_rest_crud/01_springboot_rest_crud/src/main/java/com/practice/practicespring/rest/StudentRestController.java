package com.practice.practicespring.rest;

import com.practice.practicespring.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;
    @PostConstruct
    public void loadData()
    {
        theStudent= new ArrayList<>();
        theStudent.add(new Student("Gow","G'"));
        theStudent.add(new Student("Yashmi","GT'"));
        theStudent.add(new Student("Thiru","P"));
    }
    @GetMapping("/student")
    public List<Student> getStudents()
    {

        return theStudent;

    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if((studentId>=theStudent.size() )|| (studentId<0))
        {
            throw  new StudentNotFoundException("student id not found "+ studentId);
        }
        return theStudent.get(studentId);

    }



}
