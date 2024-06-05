package com.example.api.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EventLocation {

    private int positionX;
    private int positionY;

    public EventLocation(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
