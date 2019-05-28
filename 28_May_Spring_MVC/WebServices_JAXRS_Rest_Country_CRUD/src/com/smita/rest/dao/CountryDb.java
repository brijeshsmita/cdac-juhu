/**
 * 
 */
package com.smita.rest.dao;

import java.util.HashMap;

import com.smita.rest.bean.Country;

/**
 * @author Smita
 *
 */
public class CountryDb {
	static HashMap<Integer, Country> countryMap
	=getCountryMap();
	
	static {
		if(countryMap==null) {
			countryMap = new HashMap<>();
			Country in = new Country(1, "India", 100000);
			Country ch = new Country(2, "China", 200000);
			Country usa = new Country(3, "USA", 8000);
			Country uk = new Country(4, "UK", 5000);
			
			countryMap.put(1, in);countryMap.put(2, ch);
			countryMap.put(3, usa);countryMap.put(4, uk);
		}
	}

	public static HashMap<Integer, Country> getCountryMap() {
		// TODO Auto-generated method stub
		return countryMap;
	}
	
}
