package com.example.gamebackend.Interfaces;

import com.example.gamebackend.Modules.Question;

public interface IQuestionService {
    Question getEasyQuestion();

    Question getMediumQuestion();

    Question gethardQuestion();
}
