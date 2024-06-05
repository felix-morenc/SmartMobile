package com.example.tindershoppingapp.Controller;

import com.example.tindershoppingapp.Interfaces.IClothing;
import com.example.tindershoppingapp.Module.Clothing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/clothing")
public class ClothingController {

    @Autowired
    IClothing clothing;

    @GetMapping("/randomCloting/{id}")
    public Clothing GetClothing(@PathVariable("id") int id){
        return clothing.GetClothing(id);
    }
}
