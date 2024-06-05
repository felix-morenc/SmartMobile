package com.example.gamebackend.Controller;


import com.example.gamebackend.Interfaces.IBattleService;
import com.example.gamebackend.Modules.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BattleController {

    @Autowired
    IBattleService iBattleService;

    @GetMapping("/battle/health")
    public List<String> healthBars(Question question) throws Exception {
        return iBattleService.getHealthBars();
    }

    @PostMapping("/battle/refresh/points")
    public int refreshHealthPoints(){
        iBattleService.refreshHealthPoints();
        return 1;
    }

    @PostMapping("/battle/attack")
    public void attack(@RequestBody Question question){
        iBattleService.attack(question);
    }

    @PostMapping("/battle/defend")
    public void defend(@RequestBody Question question){
        iBattleService.defend(question);
    }

}
