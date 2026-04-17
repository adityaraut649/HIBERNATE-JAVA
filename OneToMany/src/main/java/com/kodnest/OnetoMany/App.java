package com.kodnest.OnetoMany;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Course c1 = new Course("Java");
		Course c2 = new Course("Phython");
		Course c3 = new Course("C#");

		Student student = new Student("Omaker", "om@kod.in", "9988776655");

		c1.setStudent(student);
		c2.setStudent(student);
		c3.setStudent(student);

		List<Course> courses = new ArrayList<Course>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);

		student.setRef(courses);
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		 Transaction transaction = session.beginTransaction();
		 session.persist(student);
		 transaction.commit();
		 session.close();
		 factory.close();
	}
}
