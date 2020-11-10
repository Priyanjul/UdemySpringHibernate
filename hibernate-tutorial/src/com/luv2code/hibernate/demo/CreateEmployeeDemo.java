package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		 try {
			 // create an employee object
			 System.out.println("Creating new Employee object....");
			 Employee theEmployee = new Employee("Priyanjul", "Johari", "United Bank of Switzerland");
			 
			 // start a transaction
			 session.beginTransaction();
			 
			 // save the employee object
			 System.out.println("Saving the employee...");
			 session.save(theEmployee);
			 
			// commit transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
			 
		 } finally {
			 factory.close();
		 }
		
	}

}
