package com.springboot.crudpractice;

import com.springboot.crudpractice.dao.AppDAO;
import com.springboot.crudpractice.entity.Instructor;
import com.springboot.crudpractice.entity.InstructorDetail;
import org.aspectj.apache.bcel.generic.Instruction;
import org.hibernate.boot.archive.scan.spi.ScanOptions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			deleteInstructorDetail(appDAO);
		};
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
