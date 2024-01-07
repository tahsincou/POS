package com.pos.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.model.Sell;

@Repository
public interface SellRepository extends JpaRepository<Sell, Long>{
	
	List<Sell> getAllBySellDate(Date sellDate);

}
