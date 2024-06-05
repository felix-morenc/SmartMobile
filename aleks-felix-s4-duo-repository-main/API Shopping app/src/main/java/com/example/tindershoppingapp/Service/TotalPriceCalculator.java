package com.example.tindershoppingapp.Service;

import com.example.tindershoppingapp.Interfaces.IPriceCalculator;
import com.example.tindershoppingapp.Module.Clothing;
import com.example.tindershoppingapp.Module.TotalPrice;
import org.springframework.stereotype.Service;

@Service
public class TotalPriceCalculator implements IPriceCalculator {
    @Override
    public TotalPrice CalculatePrice(int quantity, Clothing clothing) {

        return new TotalPrice(quantity*clothing.getPrice());
    }
}
