package com.example.gamebackend.Modules;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
    private String answer;
    private boolean isCorrect;

    public Answer(@JsonProperty("answer")String answer,@JsonProperty("isCorrect") boolean isCorrect) {
        this.answer = answer;
        this.isCorrect = isCorrect;
    }
}
