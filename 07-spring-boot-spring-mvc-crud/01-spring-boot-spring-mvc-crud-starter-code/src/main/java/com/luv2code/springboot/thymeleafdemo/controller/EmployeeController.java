package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService)
    {
        employeeService=theEmployeeService;

    }
    @GetMapping("/list")
    public String employeesList(Model theModel)
    {
     //get employess from db
        List<Employee>  theEmployees=employeeService.findAll();
     //add to spring model
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        //create model attribute to bind form data
        Employee theEmployee= new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
    {
      //save employee
         employeeService.save(theEmployee);
      //use redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public  String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel)
    {
        Employee theEmployee=employeeService.findById(theId);
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }
    @GetMapping("/Delete")
    public  String delete(@RequestParam("employeeId") int theId,Model theModel)
    {
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }

}
