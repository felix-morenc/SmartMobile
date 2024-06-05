package com.example.tindershoppingapp.Module;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Clothing {
    private Type clothingType;
    private double price;
    private String description;
    private String imageLink;

    public Clothing(@JsonProperty("type") String clothingType,@JsonProperty("price") double price,
                    @JsonProperty("description") String description,@JsonProperty("imageLink")  String imageLink) {
        this.clothingType = checkType(clothingType);
        this.price = price;
        this.description = description;
        this.imageLink = imageLink;
    }

    private Type checkType(String type){
        switch (type){
            case "T-Shirt" : return Type.TSHIRT;
            case "Shirt" : return Type.SHIRT;
            case "Jacket" : return Type.JACKET;
            case "Jeans" : return Type.JEANS;
        }

        return Type.SHIRT;
    }
}
