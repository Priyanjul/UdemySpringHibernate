package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		 try {
			
			 // start a transaction
			 session.beginTransaction();
			
			 // create a course
			 Course tempCourse = new Course("AI - 30 din me expert banein!");
			 
			 // add some reviews
			 tempCourse.addReview(new Review("Maja a gaya!"));
			 tempCourse.addReview(new Review("Bohot badia course!"));
			 tempCourse.addReview(new Review("Sahi nahi tha!"));
			 
			 // save the course... and leverage the cascade all :-)
			 System.out.println("Saving the course");
			 System.out.println(tempCourse);
			 System.out.println(tempCourse.getReviews());
			 
			 session.save(tempCourse);
			 
			 // commit transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
			 
		 } finally {
			 
			 // add clean up code
			 session.close();
			 
			 factory.close();
		 }
		
	}

}
