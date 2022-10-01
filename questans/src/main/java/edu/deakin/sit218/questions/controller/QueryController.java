package edu.deakin.sit218.questions.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.deakin.sit218.questions.dao.QuestionDAO;
import edu.deakin.sit218.questions.dao.QuestionDAOImpl;
import edu.deakin.sit218.questions.entity.Question;

@Controller
@RequestMapping("/question")
public class QueryController {
    
    public String workout(
            @Valid @ModelAttribute("question") Question question, 
            BindingResult validationErrors, Model model) {
        //Input validation
        if (validationErrors.hasErrors()) {
            model.addAttribute("message", "Error");
            return "questions";
        }


        QuestionDAO dao = new QuestionDAOImpl(); 
        dao.insertQuestion(question);
        List<Question> questions = dao.retrieveQuestion(question.getArea());
        model.addAttribute("message", 
                "Successful. There are now " + questions.size() + " questions for area: " + question.getArea());

        //Return the View 
        return "questions";
    }
    
    public String questionsstring = "";
    
    @RequestMapping("/getQuestions")
    public String workoutx(
            @Valid @ModelAttribute("question") Question question, 
            BindingResult validationErrors, Model model) {
        //Input validation
        if (validationErrors.hasErrors()) {
            model.addAttribute("message", "Error");
            return "questions";
        }

        questionsstring = "";
        QuestionDAO dao = new QuestionDAOImpl(); 
        List<Question> questions = dao.retrieveQuestion(question.getArea());
        questions.forEach(response -> {
            questionsstring += response.getQuestion() + ",\n ";
        });
        
        
        model.addAttribute("message", 
                questionsstring);

        //Return the View 
        return "questions";
    }
    
}
