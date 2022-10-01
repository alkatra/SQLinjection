package edu.deakin.sit218.questions.dao;

import java.util.List;

import javax.validation.Valid;

import edu.deakin.sit218.questions.entity.Question;


public interface QuestionDAO {
	
	public void updateQuestion(Question question);

	public List<Question> retrieveQuestion(String area);

	public boolean existsQuestion(Question question);

    public void insertQuestion(Question question);
	
}
