package com.cdac.spring.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("currencyConverter")
public class CurrencyConverterImpl implements ICurrencyConverter {
	//spring container will automatically wire the related bean
	@Autowired //property injection
	private IExchangeService exchangeService;
	public CurrencyConverterImpl() {
		System.out.println("CurrencyConverterImpl().... bean created");
	}
//both property and contructor injection cannot be used togather
	//@Autowired //contructor injection
	public CurrencyConverterImpl(ExchangeServiceImpl exchangeService) {
		System.out.println("CurrencyConverterImpl().... bean created ");
		this.exchangeService = exchangeService;
	}
	public double dollarsToRupees(double dollars) {
		System.out.println("dollarsToRupees()");		
		return dollars * exchangeService.getExchangeRate();
		//return dollars*72.30;
	}
};