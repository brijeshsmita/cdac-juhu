package com.cdac.spring.di.service;
import org.springframework.stereotype.Component;
/*
<bean class="com.cdac.spring.di.ExchangeServiceImpl"
id="exchangeService">*/
@Component("exchangeService")
public class ExchangeServiceImpl implements IExchangeService {
	
	private double exchangeRate;

	public ExchangeServiceImpl() {
		System.out.println("ExchangeServiceImpl() bean.... created ");
	}
	
	public ExchangeServiceImpl(double exchangeRate) {
		super();
		System.out.println("ExchangeServiceImpl()bean.... created ");
		this.exchangeRate = exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		 
		this.exchangeRate = exchangeRate;
	}

	public double getExchangeRate() {
		System.out.println("ExchangeService returing exchange rates:"+exchangeRate);
		System.out.println("getExchangeRate()");
		return exchangeRate;
	}
}
