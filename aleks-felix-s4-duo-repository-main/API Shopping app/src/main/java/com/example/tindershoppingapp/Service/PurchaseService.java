package com.example.tindershoppingapp.Service;

import com.example.tindershoppingapp.Interfaces.IPurchaseCreator;
import com.example.tindershoppingapp.Module.Message;
import com.example.tindershoppingapp.Module.Purchase;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService implements IPurchaseCreator {
    @Override
    public Message createPurchaseMessage(Purchase purchase) {
        String message = "Hello, "+ purchase.getUser().getPhone() +" your purchase has been submitted, the total price is: " + purchase.getTotalPrice() +
                ".";

        return new Message(message);
    }
}
