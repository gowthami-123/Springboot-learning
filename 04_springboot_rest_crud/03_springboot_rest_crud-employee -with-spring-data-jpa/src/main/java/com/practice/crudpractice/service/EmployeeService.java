package com.practice.crudpractice.service;
import com.practice.crudpractice.enitity.Employee;

import java.util.List;
public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int theId);

    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
