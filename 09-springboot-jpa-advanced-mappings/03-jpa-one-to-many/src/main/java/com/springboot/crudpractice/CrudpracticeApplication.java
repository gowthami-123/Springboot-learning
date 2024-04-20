package com.springboot.crudpractice;

import com.springboot.crudpractice.dao.AppDAO;
import com.springboot.crudpractice.entity.Course;
import com.springboot.crudpractice.entity.Instructor;
import com.springboot.crudpractice.entity.InstructorDetail;
import org.aspectj.apache.bcel.generic.Instruction;
import org.hibernate.boot.archive.scan.spi.ScanOptions;
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
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorwithCourse(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			deleteCourse(appDAO);
		};
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
