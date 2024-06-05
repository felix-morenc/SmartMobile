package com.example.gamebackend.Modules;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Battle {

    private Hero champion;
    private Hero enemy;

    public Battle(Hero champion, Hero enemy) {
        this.champion = champion;
        this.enemy = enemy;
    }
}
