package com.cdac.spring.di;

public class CurrencyConverterImpl implements ICurrencyConverter {
	private IExchangeService exchangeService;
	public CurrencyConverterImpl() {
		System.out.println("CurrencyConverterImpl().... bean created");
	}

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