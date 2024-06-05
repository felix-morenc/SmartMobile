package com.example.tindershoppingapp.Interfaces;

import com.example.tindershoppingapp.Module.Clothing;
import com.example.tindershoppingapp.Module.TotalPrice;

public interface IPriceCalculator {

    TotalPrice CalculatePrice(int quantity, Clothing clothing);
}
