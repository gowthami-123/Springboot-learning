package com.practice.crudpractice.service;

import com.practice.crudpractice.dao.EmployeeRepository;
import com.practice.crudpractice.enitity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimp implements EmployeeService{

    private EmployeeRepository employeeRepo;
    @Autowired
    public EmployeeServiceimp(EmployeeRepository theEmployeeRepo)
    {
        this.employeeRepo=theEmployeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepo.findById(theId);
        Employee employee=null;
        if(result.isPresent())
        {
            employee=result.get();
        }
        else
        {
            throw new RuntimeException("Did not find the employee id - "+ theId);
        }
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepo.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
       employeeRepo.deleteById(theId);
    }
}
