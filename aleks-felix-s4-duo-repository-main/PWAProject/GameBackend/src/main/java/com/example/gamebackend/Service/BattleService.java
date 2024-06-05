package com.example.gamebackend.Service;

import com.example.gamebackend.Interfaces.IBattleRepository;
import com.example.gamebackend.Interfaces.IBattleService;
import com.example.gamebackend.Modules.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleService implements IBattleService {

    @Autowired
    IBattleRepository iBattleRepository;

    @Override
    public List<String> getHealthBars() {
        return iBattleRepository.getHealtBars();
    }

    @Override
    public void attack(Question question) {
        if(question.getQuestionType().equals("EASY"))
            if(question.isDoubleDamage())
                iBattleRepository.attack(40);
            else
                iBattleRepository.attack(20);
        else if(question.getQuestionType().equals("MEDIUM"))
            if(question.isDoubleDamage())
                iBattleRepository.attack(80);
            else
                iBattleRepository.attack(40);
        else if(question.getQuestionType().equals("HARD"))
            if(question.isDoubleDamage())
                iBattleRepository.attack(120);
            else
                iBattleRepository.attack(60);
    }

    @Override
    public void refreshHealthPoints() {
        iBattleRepository.refreshHealthPoints();
    }

    @Override
    public void defend(Question question) {
        if(question.getQuestionType().equals("EASY"))
            iBattleRepository.defend(20);
        else if(question.getQuestionType().equals("MEDIUM"))
            iBattleRepository.defend(40);
        else if(question.getQuestionType().equals("HARD"))
            iBattleRepository.defend(60);
    }
}
