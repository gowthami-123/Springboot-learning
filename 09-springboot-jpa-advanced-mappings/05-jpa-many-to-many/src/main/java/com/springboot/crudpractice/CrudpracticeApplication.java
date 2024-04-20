package com.springboot.crudpractice;

import com.springboot.crudpractice.dao.AppDAO;
import com.springboot.crudpractice.entity.*;
import org.aspectj.apache.bcel.generic.Instruction;
import org.hibernate.boot.archive.scan.spi.ScanOptions;
import org.hibernate.sql.ast.tree.expression.SqlTuple;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudpracticeApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return  runner->{
         //createCourseAndStudent(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourses(appDAO);
			//addMoreCoursesforStudents(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId=2;
		System.out.println("Deleting student id: "+ theId);
		appDAO.deleteStudent(theId);
	}

	private void addMoreCoursesforStudents(AppDAO appDAO) {
		int theId=2;
		Student tempStudent=appDAO.findStudentAndCoursesbyStudentId(theId);
		//create more courses
		Course tempCourse1= new Course("Python");
		Course tempCourse2=new Course("Data Structures");
		//add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		System.out.println("Updating student:"+ tempStudent);
		System.out.println("Associated courses"+ tempStudent.getCourses());

		appDAO.update(tempStudent);
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId=1;
		Student tempStudent=appDAO.findStudentAndCoursesbyStudentId(theId);
		System.out.println("Student: "+ tempStudent);
		System.out.println("Asscoiated courses: "+ tempStudent.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId=10;
		Course tempCourse=appDAO.findCourseAndStudentByCourseId(theId);
		System.out.println("Course "+ tempCourse);
		System.out.println("asscoiated students: "+ tempCourse.getStudents());
	}

	private void createCourseAndStudent(AppDAO appDAO) {
		Course tempCourse=new Course("Computer Science");
		Student tempStudent1= new Student("Gow","G","gow123@gmail.com");
		Student tempStudent2= new Student("Yashmi","TG","y123@gmail.com");
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		System.out.println("Saving the course:"+ tempCourse);
		System.out.println("Associated students:"+ tempCourse.getStudents());
		appDAO.save(tempCourse);

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		System.out.println("Deleting course id"+ theId);
		appDAO.deleteCourse(theId);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		Course tempCourse= appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
        Course tempCourse= new Course("Java,Springboot");

		tempCourse.add(new Review("Great course"));
		tempCourse.add(new Review("Best course for beginners"));
		tempCourse.add(new Review("Cool course..loved it"));

		appDAO.save(tempCourse);
		System.out.println("Course"+ tempCourse);
		System.out.println("Reviews"+ tempCourse.getReviews());
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Deleting course id "+theId);
		appDAO.deleteCourse(theId);
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Finding course id "+ theId);
		Course tempCourse=appDAO.findCourseById(theId);
		System.out.println("Before update course"+ tempCourse);
		tempCourse.setTitle("Medical Science");
		appDAO.update(tempCourse);
		System.out.println("After update course "+ tempCourse);

	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding Instructor Id"+ theId);
		Instructor tempInstructor= appDAO.findById(theId);
		System.out.println("Before update Instructor "+ tempInstructor);
		tempInstructor.setLastName("TG");
		appDAO.update(tempInstructor);
		System.out.println("After update Instructor "+ tempInstructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding Instructor Id"+ theId);
		Instructor tempInstructor= appDAO.findInstructorByJoinFetch(theId);
		System.out.println("Temp Instructor"+ tempInstructor);
		System.out.println("Associated courses"+ tempInstructor.getCourses());

	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding Instructor Id"+ theId);
		Instructor tempInstructor= appDAO.findById(theId);
		System.out.println("Temp Instructor"+ tempInstructor);
		List<Course> courses= appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("Associated Courses"+tempInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding Instructor Id"+ theId);
		Instructor tempInstructor= appDAO.findById(theId);
		System.out.println("Temp Instructor"+ tempInstructor);
		System.out.println("Associated courses"+ tempInstructor.getCourses());
	}

	private void createInstructorwithCourse(AppDAO appDAO) {
		Instructor tempInstructor= new Instructor("Yashmi","T","y123@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.mychannel.com/youtube","playing");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		Course tempCourse1=new Course("Computer Science");
		Course tempCourse2=new Course("Mathematics");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving Instructor"+ tempInstructor);
		System.out.println("Saving courses"+ tempInstructor.getCourses());
		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		System.out.println("Deleting instructor detail id"+ theId);
		appDAO.deleteByInstructorDetailId(theId);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=2;
		System.out.println("Finding Instructor Detail Id"+ theId);
		InstructorDetail tempInstructordetail=appDAO.findInstructorDetailById(theId);
		System.out.println(tempInstructordetail);
		System.out.println("Associated Instructor"+ tempInstructordetail.getInstructor());

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Delete Instructor id"+ theId);
		appDAO.deleteById(theId);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding Instructor Id"+ theId);
		Instructor tempInstructor= appDAO.findById(theId);
		System.out.println(tempInstructor);
		System.out.println("Associated Instructor details"+ tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*Instructor tempInstructor= new Instructor("Gow","G","gow@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.mychannel.com/youtube","coding");

		 */

		Instructor tempInstructor= new Instructor("Yashmi","T","y123@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.mychannel.com/youtube","playing");
         tempInstructor.setInstructorDetail(tempInstructorDetail);
         System.out.println("saving instructor"+ tempInstructor);
		 appDAO.save(tempInstructor);
	}

}
