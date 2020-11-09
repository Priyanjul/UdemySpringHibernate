package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		 try {
			
			 // start a transaction
			 session.beginTransaction();
			 
			 // query students
			 List<Student> theStudents = session.createQuery("from Student").getResultList();
			 
			 // display students
			 displayStudents(theStudents);
			 
			 // query students: lastname='Das'
			 theStudents = session.createQuery("from Student s where s.lastname='Das'").getResultList();
			 
			// display students
			 System.out.println("\n\nStudents who have last name Das");
			 displayStudents(theStudents);
			 
			 // query students: lastname='Das' OR firstname='Sahil'
			 theStudents = session.createQuery("from Student s where s.lastname='Das' OR s.firstname='Sahil'").getResultList();
			 
			// display students
			 System.out.println("\n\nStudents who have last name: Das OR firstname: Sahil");
			 displayStudents(theStudents);
			 
			 // query students where email LIKE '%yahoo.com'
			 theStudents = session.createQuery("from Student s where s.email LIKE '%yahoo.com'").getResultList();
			 
			// display students
			 System.out.println("\n\nStudents who have eamil LIKE: %yahoo.com");
			 displayStudents(theStudents);
			 
			// commit transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
			 
		 } finally {
			 factory.close();
		 }
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			 System.out.println(tempStudent);
		 }
	}

}
