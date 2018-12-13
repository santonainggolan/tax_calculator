package com.santo.shopee.taxcalcul.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TaxModelResponse {
	
	private Double priceSubTotal = 0.0;
	private Double taxSubtotal = 0.0;
	private Double grandTotal = 0.0 ;
	
	private List<TaxModelDetail> taxModelDetails = new ArrayList<TaxModelDetail>();

}
