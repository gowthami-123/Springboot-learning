package com.practice.crudpractice.dao;

import com.practice.crudpractice.enitity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class EmployeeDAOimp implements EmployeeDAO{

    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOimp(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(Integer theId) {
        Employee theEmployee= entityManager.find(Employee.class , theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee= entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
     Employee theEmployee=entityManager.find(Employee.class , theId);
     entityManager.remove(theEmployee);
    }


}
