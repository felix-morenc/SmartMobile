package com.example.gamebackend.Interfaces;

import com.example.gamebackend.Modules.Question;

import java.util.List;

public interface IBattleService {
    List<String> getHealthBars();

    void attack(Question question);

    void refreshHealthPoints();

    void defend(Question question);

}
