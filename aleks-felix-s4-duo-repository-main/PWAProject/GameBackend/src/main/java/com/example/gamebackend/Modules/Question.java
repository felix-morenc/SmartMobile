package com.example.gamebackend.Modules;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Question {

    private String question;
    private String questionType;
    private List<Answer> possibleAnswers;
    private boolean isDoubleDamage;

    public Question(@JsonProperty("question")String question,@JsonProperty("questionType") String questionType,@JsonProperty("possibleAnswers") List<Answer> possibleAnswers) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.questionType=questionType;
        this.isDoubleDamage=false;
    }
}
