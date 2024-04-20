package com.springboot.crudpractice.dao;

import com.springboot.crudpractice.entity.Course;
import com.springboot.crudpractice.entity.Instructor;
import com.springboot.crudpractice.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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

     //get courses
        List<Course> courses= tempInstructor.getCourses();

     //break association of all courses for the instructor
        for(Course tempCourse:courses)
        {
         tempCourse.setInstructor(null);
        }

     entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteByInstructorDetailId(int theId) {
        InstructorDetail tempInstructorDetail= entityManager.find(InstructorDetail.class,theId);

        //remove associated object reference
        //break bi directional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);


        entityManager.remove(tempInstructorDetail);
        

    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> theQuery= entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        theQuery.setParameter("data",theId);
        List<Course> courses= theQuery.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByJoinFetch(int theId) {
        TypedQuery<Instructor> query=entityManager.createQuery("select i from Instructor i "+ "JOIN FETCH i.courses "+
                                                              "where i.id=:data",Instructor.class);
        query.setParameter("data",theId);
        Instructor instructor= query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class,theId);
    }

    @Override
    @Transactional
    public void deleteCourse(int theId) {
        Course tempCourse= entityManager.find(Course.class, theId);
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
       entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query=entityManager.createQuery("select  c from Course c "
                                       +"JOIN FETCH  c.reviews "
                                       + "where c.id=: data",Course.class);
        query.setParameter("data",theId);
        Course course=query.getSingleResult();
        return course;
    }
}
