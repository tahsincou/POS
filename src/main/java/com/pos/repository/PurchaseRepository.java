package com.pos.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	
	List<Purchase> findAllByPurchaseDate(Date date);
}
