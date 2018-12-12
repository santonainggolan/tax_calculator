package com.santo.shopee.taxcalcul.model;

public class TaxModelDetail {
	
	private String name;
	private String code;
	private Double price;
	private String type;
	private String refundable;
	private Double tax = 0.0;
	private Double amount = 0.0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRefundable() {
		return refundable;
	}
	public void setRefundable(String refundable) {
		this.refundable = refundable;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
}
