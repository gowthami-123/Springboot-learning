package com.springboot.crudpractice.dao;

import com.springboot.crudpractice.entity.Instructor;

public interface AppDAO{
    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteById(int theId);
}
