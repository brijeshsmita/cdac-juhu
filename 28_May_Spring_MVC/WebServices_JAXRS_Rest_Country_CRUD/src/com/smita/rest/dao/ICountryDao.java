/**
 * 
 */
package com.smita.rest.dao;

import java.util.List;

import com.smita.rest.bean.Country;

/**
 * @author Smita
 *
 */
public interface ICountryDao {
	public List<Country> getAllCountries();
	public Country getCountry(int countryId);
	public Country addCountry(Country country);
	public Country deleteCountry(int countryId);
	public Country updateCountry(Country country);
}



