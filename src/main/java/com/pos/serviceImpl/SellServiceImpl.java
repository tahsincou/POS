package com.pos.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.model.Sell;
import com.pos.repository.SellRepository;
import com.pos.service.SellService;

@Service
public class SellServiceImpl implements SellService{
	
	private final SellRepository sellRepository;
	
	@Autowired
	public SellServiceImpl (SellRepository sellRepository) {
		this.sellRepository = sellRepository;
	}

	@Override
	public void saveSell(Sell sell) {
		sellRepository.save(sell);
	}

	@Override
	public List<Sell> getAllSellsByDate(Date date) {
		return sellRepository.getAllBySellDate(date);
	}

}
