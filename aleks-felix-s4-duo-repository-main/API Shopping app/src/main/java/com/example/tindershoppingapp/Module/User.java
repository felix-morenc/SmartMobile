package com.example.tindershoppingapp.Module;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {

    private String IBAN;
    private String address;
    private String phone;

    public User(@JsonProperty("IBAN")String IBAN,@JsonProperty("Address") String address,@JsonProperty("Phone") String phone) {
        this.IBAN = IBAN;
        this.address = address;
        this.phone = phone;
    }

}
