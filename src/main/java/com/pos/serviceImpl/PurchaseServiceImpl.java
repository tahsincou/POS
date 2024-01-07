package com.pos.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.model.Purchase;
import com.pos.repository.PurchaseRepository;
import com.pos.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

	@Override
	public boolean savePurchase(Purchase purchase) {
		 Purchase savedPurchase = purchaseRepository.save(purchase);
		    return savedPurchase != null;
	}

	@Override
	public List<Purchase> getAllPurchasesByDate(Date date) {
		 return purchaseRepository.findAllByPurchaseDate(date);
	}

}
