package com.example.api.entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private int id;
    private EType type;
    private String name;
    private String description;
    private String image;


    public Item(int id, EType type, String name, String description, String image) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.image = image;
    }

}
