package com.springboot.crudpractice.dao;

import com.springboot.crudpractice.entity.Instructor;
import com.springboot.crudpractice.entity.InstructorDetail;

public interface AppDAO{
    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteById(int theId);
    InstructorDetail findInstructorDetailById(int theId);

    void deleteByInstructorDetailId(int theId);
}
