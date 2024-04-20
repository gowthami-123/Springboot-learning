package com.practice.crudpractice.dao;

import com.practice.crudpractice.enitity.Employee;
import java.util.*;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(Integer theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
