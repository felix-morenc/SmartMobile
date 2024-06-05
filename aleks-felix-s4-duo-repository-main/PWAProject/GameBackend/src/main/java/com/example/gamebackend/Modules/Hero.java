package com.example.gamebackend.Modules;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class Hero {

    private  int healthPoints;

    public Hero(){
        this.healthPoints=175;
    }

    public void setHealthPoints(int value){
        if(value==175){
            this.healthPoints=value;
        }
        else if(healthPoints-value>=0){
            this.healthPoints-=value;
        }
        else{
            this.healthPoints=0;
        }
    }
}
