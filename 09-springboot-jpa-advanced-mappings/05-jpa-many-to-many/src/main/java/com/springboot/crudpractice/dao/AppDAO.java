package com.springboot.crudpractice.dao;

import com.springboot.crudpractice.entity.Course;
import com.springboot.crudpractice.entity.Instructor;
import com.springboot.crudpractice.entity.InstructorDetail;
import com.springboot.crudpractice.entity.Student;
import org.hibernate.sql.ast.tree.expression.SqlTuple;

import java.util.List;

public interface AppDAO{
    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteById(int theId);
    InstructorDetail findInstructorDetailById(int theId);

    void deleteByInstructorDetailId(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course course);

    Course findCourseById(int theId);

    void deleteCourse(int theId);

    void  save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentByCourseId(int theId);

    Student findStudentAndCoursesbyStudentId(int theId);

    void update(Student theStudent);

    void deleteStudent(int theId);
}
