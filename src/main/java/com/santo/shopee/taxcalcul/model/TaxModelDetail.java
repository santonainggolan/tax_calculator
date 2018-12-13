package com.santo.shopee.taxcalcul.model;

import lombok.Data;

@Data
public class TaxModelDetail {
	
	private String name;
	private String code;
	private Double price;
	private String type;
	private String refundable;
	private Double tax = 0.0;
	private Double amount = 0.0;
}
