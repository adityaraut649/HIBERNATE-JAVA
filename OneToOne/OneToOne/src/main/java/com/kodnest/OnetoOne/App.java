package com.kodnest.OnetoOne;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	// Load Hibernate Configuration
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        //Open Session
        Session session = sessionFactory.openSession();
        
        //Begin Transaction
        Transaction transaction = session.beginTransaction();
        
        System.err.println("Enter the Stree , city, state, zipcode, conntry ");
        Address address = new Address(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next());
        
        System.err.println("Enter name , email, phone");
        Kodneststudent student = new Kodneststudent(sc.next(), sc.next(), sc.next(), address);
        
        session.persist(student);
        
        transaction.commit();
        System.err.println("Student and Address saved successfully!");
        
        
        session.close();
        sessionFactory.close();
    }
}
