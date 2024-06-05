package com.example.tindershoppingapp.Controller;

import com.example.tindershoppingapp.Interfaces.IPurchaseCreator;
import com.example.tindershoppingapp.Module.Message;
import com.example.tindershoppingapp.Module.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/purchase")
@CrossOrigin
public class PurchaseController {

    @Autowired
    IPurchaseCreator purchaseService;

    @PostMapping("/message")
    public Message GetPurcahseMessage(@RequestBody Purchase purchase){
        return purchaseService.createPurchaseMessage(purchase);
    }
}
