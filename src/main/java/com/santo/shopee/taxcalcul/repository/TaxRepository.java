package com.santo.shopee.taxcalcul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santo.shopee.taxcalcul.model.TaxModel;

public interface TaxRepository extends JpaRepository<TaxModel, Integer> {

}
