package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a student object
			System.out.println("Creating new student object...");
			
			Student tempStudent = new Student("suraj", "dhulap", "student@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			// save the student object
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// Now get new session and start transaction
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			
			 // Retrieve student based on the id
			 System.out.println("Get Complete" +tempStudent.getId());
			 
			 Student myStudent = session.get(Student.class, tempStudent.getId());
			 
			 System.out.println("Get Complete" +myStudent);
			 
			 session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
