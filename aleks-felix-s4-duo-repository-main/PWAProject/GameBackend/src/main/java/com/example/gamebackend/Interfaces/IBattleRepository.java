package com.example.gamebackend.Interfaces;

import com.example.gamebackend.Modules.Question;

import java.util.List;

public interface IBattleRepository {
    List<String> getHealtBars();

    void attack(int attackDamage);

    void refreshHealthPoints();

    void defend(int attackDamage);
}
