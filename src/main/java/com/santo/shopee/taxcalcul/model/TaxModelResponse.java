package com.santo.shopee.taxcalcul.model;

import java.util.ArrayList;
import java.util.List;

public class TaxModelResponse {
	
	private Double priceSubTotal = 0.0;
	private Double taxSubtotal = 0.0;
	private Double grandTotal = 0.0 ;
	
	private List<TaxModelDetail> taxModelDetails = new ArrayList<TaxModelDetail>();


	public Double getPriceSubTotal() {
		return priceSubTotal;
	}

	public void setPriceSubTotal(Double priceSubTotal) {
		this.priceSubTotal = priceSubTotal;
	}

	public Double getTaxSubtotal() {
		return taxSubtotal;
	}

	public void setTaxSubtotal(Double taxSubtotal) {
		this.taxSubtotal = taxSubtotal;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<TaxModelDetail> getTaxModelDetails() {
		return taxModelDetails;
	}

	public void setTaxModelDetails(List<TaxModelDetail> taxModelDetails) {
		this.taxModelDetails = taxModelDetails;
	}
	
	

}
