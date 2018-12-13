package com.santo.shopee.taxcalcul.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santo.shopee.taxcalcul.model.TaxAmountDTO;
import com.santo.shopee.taxcalcul.model.TaxModel;
import com.santo.shopee.taxcalcul.model.TaxModelDetail;
import com.santo.shopee.taxcalcul.model.TaxModelResponse;
import com.santo.shopee.taxcalcul.service.TaxService;


@RestController
@RequestMapping(path = "/tax_amount/")
public class TaxController {
	
	@Autowired
	TaxService taxService;
	
	@RequestMapping(value ="test",method = RequestMethod.GET)
	public String test(){
		
		return taxService.test();
	}
	@RequestMapping(value ="get_all",method = RequestMethod.GET)
	public TaxModelResponse getAll(){
		
		 List<TaxModel>  taxModels = new ArrayList<TaxModel>();
		 taxModels = taxService.getAll(); 
		 TaxModelResponse taxModelResponse = new TaxModelResponse();
		 List<TaxModelDetail> taxModelDetail = new ArrayList<TaxModelDetail>();
		 
		 taxModels.forEach((taxModel)->{
			 TaxModelDetail taxModelDetails = new TaxModelDetail();
			 taxModelDetails = taxService.mapData(taxModelDetails,taxModel);
			 
			 taxModelResponse.setPriceSubTotal(taxService.setPriceSubTotal(taxModelResponse.getPriceSubTotal(),taxModelDetails.getPrice()));
			 taxModelResponse.setTaxSubtotal(taxService.setTaxSubtotal(taxModelResponse.getTaxSubtotal(),taxModelDetails.getTax()));
			 taxModelResponse.setGrandTotal(taxService.setGrantTotal(taxModelResponse.getPriceSubTotal(),taxModelResponse.getTaxSubtotal()));
			
			 taxModelDetail.add(taxModelDetails);
			 
			 
			 });
		 taxModelResponse.setTaxModelDetails(taxModelDetail);
		 
		return taxModelResponse;
	}
	@RequestMapping(value ="save_one",method = RequestMethod.POST)
	public String saveOne(@RequestBody TaxModel taxModel){
		return taxService.saveOne(taxModel);
	}
	
	@RequestMapping(value ="save_all",method = RequestMethod.POST)
	public String saveAll(@RequestBody TaxAmountDTO listTaxModel){
		return taxService.saveAll(listTaxModel.getData());
	}
}
