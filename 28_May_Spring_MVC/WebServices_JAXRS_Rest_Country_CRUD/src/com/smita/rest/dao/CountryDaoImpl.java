package com.smita.rest.dao;

import java.util.ArrayList;
import java.util.List;

import com.smita.rest.bean.Country;
/**
 * 
 * @author Smita
 *
 */

public class CountryDaoImpl implements ICountryDao {

	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		List<Country> countryList = new ArrayList<Country>(CountryDb.getCountryMap().values());
		return countryList;
	}

	@Override
	public Country addCountry(Country country) {
		CountryDb.getCountryMap().put(country.getCountryId(), country);
		return country;
	}

	@Override
	public Country deleteCountry(int id) {
		// TODO Auto-generated method stub
		return CountryDb.getCountryMap().remove(id);
	}

	@Override
	public Country getCountry(int countryId) {
		// TODO Auto-generated method stub
		return CountryDb.getCountryMap().get(countryId);
	}

	

	@Override
	public Country updateCountry(Country country) {
		// TODO Auto-generated method stub
		return CountryDb.getCountryMap().put(country.getCountryId(), country);
	}

}
