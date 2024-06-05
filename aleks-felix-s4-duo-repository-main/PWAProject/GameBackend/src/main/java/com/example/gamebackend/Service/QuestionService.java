package com.example.gamebackend.Service;

import com.example.gamebackend.Interfaces.IQuestionRepository;
import com.example.gamebackend.Interfaces.IQuestionService;
import com.example.gamebackend.Modules.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    IQuestionRepository iQuestionRepository;

    @Override
    public Question getEasyQuestion() {
        return iQuestionRepository.getEasyQuestion();
    }

    @Override
    public Question getMediumQuestion() {
        return iQuestionRepository.getMediumQuestion();
    }

    @Override
    public Question gethardQuestion() {
        return iQuestionRepository.gethardQuestion();
    }
}
