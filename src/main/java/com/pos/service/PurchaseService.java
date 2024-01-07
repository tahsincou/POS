package com.pos.service;

import java.util.*;

import com.pos.model.Purchase;

public interface PurchaseService {
    boolean savePurchase(Purchase purchase);

    List<Purchase> getAllPurchasesByDate(Date sellDate);

    // Add other service methods as needed
}
