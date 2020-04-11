package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrmiaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
		Student tempStudent = new Student("suraj", "dhulap", "student@gmail.com");
		Student tempStudent1 = new Student("suraj1", "dhulap1", "student1@gmail.com");
		Student tempStudent2 = new Student("suraj2", "dhulap2", "student2@gmail.com");
		
		session.beginTransaction();
		
		session.save(tempStudent);
		session.save(tempStudent1);
		session.save(tempStudent2);
		
		session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
