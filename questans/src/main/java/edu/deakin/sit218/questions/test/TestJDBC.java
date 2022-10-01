package edu.deakin.sit218.questions.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.deakin.sit218.questions.entity.Question;


public class TestJDBC {
    
	
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost/questansdb?" +
                "user=lecturer&password=lecturer";
		try {
			System.out.println("Connecting to Database");
			Connection conn =
		       DriverManager.getConnection(jdbcURL);
			System.out.println("Connection successful!");
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();

		try {
			//use the session object to save Java Object
			
			//Create a client object 
			Question question = new Question("Where is Canberra?", "ACT", "Geography");
				
			//start a transaction
			session.beginTransaction();
			
			//save the client object
			session.save(question);
			
			//commit transaction 
			session.getTransaction().commit();
			
		}
		finally {
			//close session and factory
			session.close();
			factory.close();
		}

	}

}	