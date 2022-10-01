package edu.deakin.sit218.questions.entity;

import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "question") // Just to be explicit
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
//	@NotNull(message = "is required")
	@Pattern(regexp = "^.*", message = "Invalid")
	@Column(name = "Question")
	protected String question;

	@Pattern(regexp = "^.*", message = "Invalid")
	@Column(name = "Answer")
	protected String answer;

	@Pattern(regexp = "^.*", message = "Invalid")
	@Column(name = "Area")
	protected String area;

	public Question(String question, String answer, String area) {
		super();
		this.question = question;
		this.answer = answer;
		this.area = area;

	}

	public Question() {
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "question = [question: "+ getQuestion()+", area: "+ getArea()+
				", answer: "+ getAnswer()+"]";
	}
}
