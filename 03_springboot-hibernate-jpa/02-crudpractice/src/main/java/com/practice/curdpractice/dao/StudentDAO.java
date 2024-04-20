package com.practice.curdpractice.dao;

import com.practice.curdpractice.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();
}
