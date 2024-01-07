package com.pos.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pos.model.Purchase;
import com.pos.model.Sell;
import com.pos.service.PurchaseService;
import com.pos.service.SellService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class TransactionController {
	
	 	private final PurchaseService purchaseService;
	    private final SellService sellService;

	    @Autowired
	    public TransactionController(PurchaseService purchaseService, SellService sellService) {
	        this.purchaseService = purchaseService;
	        this.sellService = sellService;
	    }
	 

	    @PostMapping("/purchase/save")
	    public String saveOrUpdatePurchase(@ModelAttribute("purchase") Purchase purchase) {
	        purchaseService.savePurchase(purchase);
	        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = dateFormatter.format(purchase.getPurchaseDate());
	        return "redirect:/purchase?date=" +formattedDate;
	    }

	    
	    @GetMapping("/purchase")
	    public String getPurchaseByDate(@RequestParam(value = "date", required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date date, 
	    		Model model, HttpServletRequest request) {
	        List<Purchase> purchaseList;
	        
	        if (date != null) {
	            purchaseList = purchaseService.getAllPurchasesByDate(date);
	        } else {
	            purchaseList = Collections.emptyList();
	        }

	        model.addAttribute("purchaseList", purchaseList);
	        model.addAttribute("purchase", new Purchase()); 

	        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
	            return "purchase :: #purchaseTable";
	        } else {
	            return "purchase";
	        }
	    }
	    
	    @PostMapping("/sell/save")
	    public String saveOrUpdateSell(@ModelAttribute("sell") Sell sell) {
	        sellService.saveSell(sell);
	        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = dateFormatter.format(sell.getSellDate());
	        return "redirect:/sell?date=" +formattedDate;
	        
	    }

	    @GetMapping("/sell")
	    public String getSellByDate(@RequestParam (value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
	    	Model model, HttpServletRequest request) {
	    	List<Sell> sellList;
	    	
	    	 if (date != null) {
	    		 sellList = sellService.getAllSellsByDate(date);
	    	 }else {
	    		 sellList = Collections.emptyList();
	    	 }
	    	 
	    	 model.addAttribute("sellList", sellList);
		     model.addAttribute("sell", new Sell());
		     
		     if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
		            return "sell :: #sellTable";
		        } else {
		            return "sell";
		        }
	    }

}
