/**
 * 
 */
package com.cdac.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cdac.spring.di.service.CurrencyConverterImpl;
import com.cdac.spring.di.service.ExchangeServiceImpl;
import com.cdac.spring.di.service.ICurrencyConverter;
import com.cdac.spring.di.service.IExchangeService;

/**
 * @author Smita B Kumar
 *
 */
//prep-work -> mark the class with @Configuration
@Configuration
public class SpringJavaConfig {
	
	@Bean(name="exchangeService")
	public IExchangeService getGreeting() {
		return new ExchangeServiceImpl();
	}
	@Bean(name="currencyConverter")
	public ICurrencyConverter getCurrencyConverterImpl() {
		return new CurrencyConverterImpl();
	}

}
