/**
 * 
 */
package com.smita.rest.service;

import java.util.List;

import com.smita.rest.bean.Country;
import com.smita.rest.dao.CountryDaoImpl;
import com.smita.rest.dao.ICountryDao;

/**
 * @author Smita
 *
 */
public class CountryServiceImpl implements ICountryService {
//step 1 : create instance var of dao interface
			private ICountryDao countryDao;
//step 2 : create the object of dao class in contructor
			public CountryServiceImpl() {
				countryDao=new CountryDaoImpl();
			}
//step 3 : invoke dao layer method in each method of service
	/* (non-Javadoc)
	 * @see com.smita.rest.service.ICountryService#getAllCountries()
	 */
	@Override
	public List<Country> getAllCountries() {
		return countryDao.getAllCountries();
	}
	/* (non-Javadoc)
	 * @see com.smita.rest.service.ICountryService#getCountry(int)
	 */
	@Override
	public Country getCountry(int countryId) {
		return countryDao.getCountry(countryId);
	}
	/* (non-Javadoc)
	 * @see com.smita.rest.service.ICountryService#addCountry(com.smita.rest.bean.Country)
	 */
	@Override
	public Country addCountry(Country country) {
		return countryDao.addCountry(country);
	}
	/* (non-Javadoc)
	 * @see com.smita.rest.service.ICountryService#deteleCountry(int)
	 */
	@Override
	public Country deleteCountry(int countryId) {
		return countryDao.deleteCountry(countryId);
	}
	/* (non-Javadoc)
	 * @see com.smita.rest.service.ICountryService#updateCountry(com.smita.rest.bean.Country)
	 */
	@Override
	public Country updateCountry(Country country) {
		return countryDao.updateCountry(country);
	}

}
