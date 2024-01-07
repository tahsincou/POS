package com.pos.model;
import lombok.Data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String buyerName;

    private String buyerPhone;

    private Double purchaseCost;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    private Date purchaseDate;

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public Double getPurchaseCost() {
		return purchaseCost;
	}

	public void setPurchaseCost(Double purchaseCost) {
		this.purchaseCost = purchaseCost;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
