package com.example.tindershoppingapp.Module;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Purchase {
    private Clothing clothing;
    private int quantity;
    private double totalPrice;
    private User user;

    public Purchase(@JsonProperty("clothing")Clothing clothing, @JsonProperty("quantity")int quantity, @JsonProperty("totalPrice")double totalPrice,@JsonProperty("user") User user) {
        this.clothing = clothing;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.user=user;
    }
}
