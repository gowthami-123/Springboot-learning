package com.practice.crudpractice.rest;

import com.practice.crudpractice.dao.EmployeeDAO;
import com.practice.crudpractice.enitity.Employee;
import com.practice.crudpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
     @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        this.employeeService=theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
      return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
      Employee theEmployee= employeeService.findById(employeeId);
      if(theEmployee==null)
      {
          throw new RuntimeException("Employee id not found -"+ employeeId);
      }
      return theEmployee;

    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
   //employee.setId(0);
   Employee dbEmployee= employeeService.save(employee);
   return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        Employee dbEmployee= employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee employee=employeeService.findById(employeeId);
        if(employee==null)
        {
            throw new RuntimeException("Employee doesn't exist-"+ employeeId);
        }

        employeeService.deleteById(employeeId);
        return  "Deeleted Employee Id"+employeeId;
    }

}