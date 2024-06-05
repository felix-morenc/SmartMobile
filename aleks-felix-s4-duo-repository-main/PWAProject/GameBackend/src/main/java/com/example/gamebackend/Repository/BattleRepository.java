package com.example.gamebackend.Repository;

import com.example.gamebackend.Interfaces.IBattleRepository;
import com.example.gamebackend.Modules.Battle;
import com.example.gamebackend.Modules.Hero;
import com.example.gamebackend.Modules.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BattleRepository implements IBattleRepository {

    private Battle battle;

    public BattleRepository() {
        Hero champion = new Hero();
        Hero enemy = new Hero();
        this.battle = new Battle(champion,enemy);
    }

    @Override
    public List<String> getHealtBars() {
        List<String> helatBars = new ArrayList<>();
        helatBars.add(String.valueOf(battle.getChampion().getHealthPoints()));
        helatBars.add(String.valueOf(battle.getEnemy().getHealthPoints()));
        return helatBars;
    }

    @Override
    public void attack(int attackDamage) {
        battle.getEnemy().setHealthPoints(attackDamage);
    }

    @Override
    public void refreshHealthPoints() {
        this.battle.getChampion().setHealthPoints(175);
        this.battle.getEnemy().setHealthPoints(175);
    }

    @Override
    public void defend(int attackDamage) {
        battle.getChampion().setHealthPoints(attackDamage);
    }
}
