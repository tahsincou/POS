package com.pos.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Report {
	
	private Double totalPurchase;
    private Double totalSell;
    private Double totalPaid;
    private Double totalDue;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    private Date purchaseDate;
    
    public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Double getTotalPurchase() {
		return totalPurchase;
	}
	public void setTotalPurchase(Double totalPurchase) {
		this.totalPurchase = totalPurchase;
	}
	public Double getTotalSell() {
		return totalSell;
	}
	public void setTotalSell(Double totalSell) {
		this.totalSell = totalSell;
	}
	public Double getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(Double totalPaid) {
		this.totalPaid = totalPaid;
	}
	public Double getTotalDue() {
		return totalDue;
	}
	public void setTotalDue(Double totalDue) {
		this.totalDue = totalDue;
	}
}