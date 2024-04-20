package com.practice.curdpractice;

import com.practice.curdpractice.dao.StudentDAO;
import com.practice.curdpractice.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;
@SpringBootApplication
public class CurdpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdpracticeApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
   return runner->{
		  createStudents(studentDAO);
		   readStudent(studentDAO);
		  queryForStudents(studentDAO);
		  queryForFindbyLastName(studentDAO);
	     update(studentDAO);
	     remove(studentDAO);
	   deleteAllStudents(studentDAO);
	   };
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		Integer deletedRows=studentDAO.deleteAll();
		System.out.println("No.of rows deleted"+ deletedRows);
	}

	private void remove(StudentDAO studentDAO) {
		Integer theId= 4;
		studentDAO.delete(4);
		
	}


	private void update(StudentDAO studentDAO) {
		Integer theId= 1;
		Student student=studentDAO.findById(theId);
		student.setLastName("Govindaraj");
		studentDAO.update(student);
		System.out.println(student);
	}


	private void queryForFindbyLastName(StudentDAO studentDAO) {
		List<Student> theStudents= studentDAO.findByLastName("G");
		for(Student student:theStudents)
		{
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents= studentDAO.findAll();
        for(Student student:theStudents)
		{
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student=new Student("gow","G","gowthami123@gmail.com");
		studentDAO.save(student);
		Integer id= student.getId();
		Student newStud= studentDAO.findById(id);
		System.out.println("Student details" + newStud);
	}


 private void createStudents(StudentDAO studentDAO) {
		Student student=new Student("gowthami","G","gowthami123@gmail.com");
		Student student1=new Student("yashmi","GT","yashmi123@gmail.com");
		Student student2=new Student("thiru","P","thiru123@gmail.com");
		studentDAO.save(student);
		studentDAO.save(student1);
		studentDAO.save(student2);

		System.out.println("student id"+ student.getId());
		System.out.println("student id"+ student1.getId());
		System.out.println("student id"+ student2.getId());
	}
	}
























