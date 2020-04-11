package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Student> theStudent = session.createQuery("from Student").list();
			
			//displayStudent(theStudent);
			
			theStudent = session.createQuery("from Student s where s.lastName='dhulap'").list();
			
			// Display the student
			//displayStudent(theStudent);
			
			theStudent = session.createQuery("from Student s where s.lastName='dhulap' or s.firstName='suraj'").list();
			//displayStudent(theStudent);

			
			// query students where email like 'gmail.com'	
			
			theStudent = session.createQuery("from Student s where s.email like 'gmail.com'").list();
			
			displayStudent(theStudent);

			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudent) {
		for(Student tempStudent: theStudent) {
			System.out.println(tempStudent);
		}
	}

}
