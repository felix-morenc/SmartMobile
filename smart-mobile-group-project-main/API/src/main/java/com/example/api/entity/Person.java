package com.example.api.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Person {
    private int id;
    private int ticketID;
    private int userType;

    public Person(int id, int ticketID, int userType) {
        this.id = id;
        this.ticketID = ticketID;
        this.userType = userType;
    }


}
