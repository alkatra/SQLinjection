package edu.deakin.sit218.questions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.deakin.sit218.questions.entity.Question;



@Controller
@RequestMapping("/question")
public class QuestionSubmitController {
	
	@RequestMapping("/showForm")
	 	public String showForm(Model model) {
		//Create a client object
		Question question = new Question();
		
		//add client object to model
		model.addAttribute("question", question);
		
		return "submitqests";
	}
	
}

