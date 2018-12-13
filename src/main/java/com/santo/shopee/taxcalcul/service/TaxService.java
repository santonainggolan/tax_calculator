package com.santo.shopee.taxcalcul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santo.shopee.taxcalcul.model.TaxModel;
import com.santo.shopee.taxcalcul.model.TaxModelDetail;
import com.santo.shopee.taxcalcul.repository.TaxRepository;

@Service
public class TaxService {

	@Autowired
	TaxRepository taxRepository;
	
	public String test() {
		return "sdsads";
	}
	
	public List<TaxModel> getAll(){
		return taxRepository.findAll();
	}
	
	public String saveOne(TaxModel taxModel) {
		taxRepository.save(taxModel);
		return "Success";
	}
	
	public String saveAll(List<TaxModel> listTaxModel) {
		taxRepository.saveAll(listTaxModel);
		return "Success";
	}

	public TaxModelDetail mapData(TaxModelDetail taxModelDetails, TaxModel taxModel) {
		// TODO Auto-generated method stub
		taxModelDetails.setCode(taxModel.getCode());
		taxModelDetails.setName(taxModel.getName());
		taxModelDetails.setPrice(taxModel.getPrice());
		taxModelDetails.setRefundable(setRefund(taxModel.getCode()));
		taxModelDetails.setType(setType(taxModel.getCode()));
		taxModelDetails.setTax(setTax(taxModel.getCode(),taxModel.getPrice()));
		taxModelDetails.setAmount(setAmount(taxModelDetails.getTax(),taxModelDetails.getPrice()));
		return taxModelDetails;
	}

	private Double setAmount(Double tax, Double price) {
		Double amount = tax + price;
		return amount;
	}

	private Double setTax(String code, Double price) {
		// TODO Auto-generated method stub
		Double tax = 0.0;
		if(code.equals("1")) {
			tax = (10 * 0.01)*price;
		}else if(code.equals("2")){
			tax = 10 + ((2 * 0.01)*price);
		}else if(code.equals("3")) {
			tax = (price >= 0.0 && price < 100.0 ? 0:(0.01*(price-100)));
			
		}
		return tax;
	}

	private String setType(String code) {
		// TODO Auto-generated method stub
		String type ="";
		if(code.equals("1")) {
			type = "Food & Beverage";
		}else if(code.equals("2")){
			type = "Tobacco";
		}else if(code.equals("3")) {
			type = "Entertainment";
		}
		return type;
	}

	private String setRefund(String code) {
		// TODO Auto-generated method stub
		String type ="";
		if(code.equals("1")) {
			type = "Y";
		}else if(code.equals("2") || code.equals("3")){
			type = "N";
		}
		return type;
	}

	public Double setPriceSubTotal(Double priceSubTotal, Double price) {
		// TODO Auto-generated method stub
		return priceSubTotal + price;
	}

	public Double setTaxSubtotal(Double taxSubtotal, Double tax) {
		// TODO Auto-generated method stub
		return taxSubtotal + tax; 
	}

	public Double setGrantTotal(Double priceSubTotal, Double taxSubtotal) {
		// TODO Auto-generated method stub
		return priceSubTotal + taxSubtotal;
	}

	
}
