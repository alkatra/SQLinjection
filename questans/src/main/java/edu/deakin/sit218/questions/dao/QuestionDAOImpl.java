package edu.deakin.sit218.questions.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import edu.deakin.sit218.questions.entity.Question;



public class QuestionDAOImpl implements QuestionDAO{
	
	SessionFactory factory;

	public QuestionDAOImpl() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.buildSessionFactory();
	}
	
	
	public void updateQuestion(Question question) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(question);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}	
	}



	/* 
	 * If the client exists in the database, this method returns
	 * the persistent client. Otherwise, it inserts a new client
	 * with the name and age provided as an argument. 
	 */
	public List<Question> retrieveQuestion(String area) {
		Session session = factory.getCurrentSession();
		try {
			//use the session object to check for a client
			//start a transaction
			session.beginTransaction();
			
			//create the query
			String hql = "FROM Question WHERE area = '"+
					area + "'";
			Query<Question> query = session.createQuery(hql);
			//Obtain the query results
			List<Question> questions = query.getResultList();
			if (questions.isEmpty()) {
				throw new RuntimeException("There is no questions for : "+ area);
			}
			else {
				return questions;
			}
		}
		finally {
			session.close();
		}
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		//Close session factory before destroying the object
		factory.close();
	}


    @Override
    public void insertQuestion(edu.deakin.sit218.questions.entity.Question question) {
        // TODO Auto-generated method stub
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(question);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        } 
    }


    @Override
    public boolean existsQuestion(Question question) {
        // TODO Auto-generated method stub
        return false;
    }
	
}
