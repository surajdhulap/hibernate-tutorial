package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			// Now get new session and start transaction
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			
			 // Retrieve student based on the id
			 System.out.println("\n getting student with the id:" +studentId);
			 
			 Student myStudent = session.get(Student.class, studentId);
			 
			 System.out.println("get complete:" +myStudent);
			 
			 System.out.println("Updating student...");
			 myStudent.setFirstName("scooby");
			 
			 session.getTransaction().commit();
			 
			 // New Code
			 
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			 
			 System.out.println("Update email for all students");
			 session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			 session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
