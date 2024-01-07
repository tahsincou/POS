package com.pos.model;

import lombok.Data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "sells")
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sellerName;

    private String sellerPhone;

    private Double sellPrice;

    private Double paid;

    private Double due;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    private Date sellDate;

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Double getPaid() {
		return paid;
	}

	public void setPaid(Double paid) {
		this.paid = paid;
	}

	public Double getDue() {
		return due;
	}

	public void setDue(Double due) {
		this.due = due;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
}
