package com.example.gamebackend.Repository;

import com.example.gamebackend.Interfaces.IQuestionRepository;
import com.example.gamebackend.Modules.Answer;
import com.example.gamebackend.Modules.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionRepository implements IQuestionRepository {

    List<Question> questions;
    List<Answer> possibleAnswersEasy = new ArrayList<>();
    List<Answer> possibleAnswersMedium = new ArrayList<>();
    List<Answer> possibleAnswersHard = new ArrayList<>();

    private void buildQuestion(){

        buildAnswersForEasyQuesiton();
        Question easyQuestion = new Question("65+26=?","EASY",possibleAnswersEasy);

        buildAnswersForMediumQuesiton();
        Question mediumQuestion = new Question("65-x=36","MEDIUM",possibleAnswersMedium);

        buildAnswersForHardQuesiton();
        Question hardQuestion = new Question("2+x+5=x+7","HARD",possibleAnswersHard);

        questions.add(easyQuestion);
        questions.add(mediumQuestion);
        questions.add(hardQuestion);
    }

    private void buildAnswersForEasyQuesiton(){
        Answer easyQuestionAnswer = new Answer("91",true);
        Answer mediumQuestionAnswer = new Answer("29",false);
        Answer hardQuestionAnswer = new Answer("0",false);

        possibleAnswersEasy.add(easyQuestionAnswer);
        possibleAnswersEasy.add(mediumQuestionAnswer);
        possibleAnswersEasy.add(hardQuestionAnswer);
    }

    private void buildAnswersForMediumQuesiton(){
        Answer easyQuestionAnswer = new Answer("91",false);
        Answer mediumQuestionAnswer = new Answer("29",true);
        Answer hardQuestionAnswer = new Answer("0",false);

        possibleAnswersMedium.add(easyQuestionAnswer);
        possibleAnswersMedium.add(mediumQuestionAnswer);
        possibleAnswersMedium.add(hardQuestionAnswer);
    }

    private void buildAnswersForHardQuesiton(){
        Answer easyQuestionAnswer = new Answer("91",false);
        Answer mediumQuestionAnswer = new Answer("29",false);
        Answer hardQuestionAnswer = new Answer("0",true);

        possibleAnswersHard.add(easyQuestionAnswer);
        possibleAnswersHard.add(mediumQuestionAnswer);
        possibleAnswersHard.add(hardQuestionAnswer);
    }

    public QuestionRepository(List<Question> questions) {
        this.questions = questions;
        buildQuestion();
    }


    @Override
    public Question getEasyQuestion() {

        for (Question question1:questions
             ) {
            if(question1.getQuestionType().equals("EASY"))
                return question1;
        }
        return null;
    }

    @Override
    public Question getMediumQuestion() {
        for (Question question1:questions
        ) {
            if(question1.getQuestionType().equals("MEDIUM"))
                return question1;
        }
        return null;
    }

    @Override
    public Question gethardQuestion() {
        for (Question question1:questions
        ) {
            if(question1.getQuestionType().equals("HARD"))
                return question1;
        }
        return null;
    }
}
