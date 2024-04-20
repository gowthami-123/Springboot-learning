package com.springboot.crudpractice.dao;

import com.springboot.crudpractice.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;
    public AppDAOImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
     Instructor tempInstructor= entityManager.find(Instructor.class,theId);

     entityManager.remove(tempInstructor);
    }
}
