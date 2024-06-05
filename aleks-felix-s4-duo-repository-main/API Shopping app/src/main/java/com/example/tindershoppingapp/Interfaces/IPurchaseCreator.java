package com.example.tindershoppingapp.Interfaces;

import com.example.tindershoppingapp.Module.Message;
import com.example.tindershoppingapp.Module.Purchase;

public interface IPurchaseCreator {
    Message createPurchaseMessage(Purchase purchase);
}
