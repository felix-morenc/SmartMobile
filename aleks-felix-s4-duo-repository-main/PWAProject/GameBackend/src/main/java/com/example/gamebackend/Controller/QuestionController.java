package com.example.gamebackend.Controller;

import com.example.gamebackend.Interfaces.IQuestionService;
import com.example.gamebackend.Modules.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    IQuestionService iQuestionService;

    @GetMapping("/question/easy")
    public Question getEasyQuestion(){
        return iQuestionService.getEasyQuestion();
    }

    @GetMapping("/question/medium")
    public Question getMediumQuestion(){
        return iQuestionService.getMediumQuestion();
    }

    @GetMapping("/question/hard")
    public Question getHardQuestion(){
        return iQuestionService.gethardQuestion();
    }
}
