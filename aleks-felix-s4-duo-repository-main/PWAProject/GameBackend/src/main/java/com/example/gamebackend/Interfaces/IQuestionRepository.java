package com.example.gamebackend.Interfaces;

import com.example.gamebackend.Modules.Question;

public interface IQuestionRepository {

    Question getEasyQuestion();

    Question getMediumQuestion();

    Question gethardQuestion();
}
