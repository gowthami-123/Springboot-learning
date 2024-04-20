package com.practice.curdpractice.dao;

import com.practice.curdpractice.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimp  implements StudentDAO{
    private EntityManager entityManager;

    // inject entitymanager using constructor injection
    @Autowired
    public StudentDAOimp(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent) {
   entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class , id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student order by lastName", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData",theLastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student=entityManager.find(Student.class ,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
