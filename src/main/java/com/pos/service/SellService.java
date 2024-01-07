package com.pos.service;
import java.util.*;

import com.pos.model.Sell;

public interface SellService {
	
	void saveSell(Sell sell);
	
	List<Sell> getAllSellsByDate(Date date);

}
