package com.example.tindershoppingapp.Controller;

import com.example.tindershoppingapp.Interfaces.IPriceCalculator;
import com.example.tindershoppingapp.Module.Clothing;
import com.example.tindershoppingapp.Module.TotalPrice;
import com.example.tindershoppingapp.Service.TotalPriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/calculator")
@CrossOrigin
public class CalculatorController {
    @Autowired
    IPriceCalculator totalPriceCalculator;

    @PostMapping("/price/{quantity}")
    public TotalPrice CalculateTotalPrice(@RequestBody Clothing clothing, @PathVariable("quantity") int quantity){
        return totalPriceCalculator.CalculatePrice(quantity, clothing);
    }
}
