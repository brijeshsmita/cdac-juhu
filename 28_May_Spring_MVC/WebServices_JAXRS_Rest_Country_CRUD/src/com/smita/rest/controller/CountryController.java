/**
 * 
 */
package com.smita.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.smita.rest.bean.Country;
import com.smita.rest.service.CountryServiceImpl;
import com.smita.rest.service.ICountryService;

/**
 * @author 10649766
 *
 */
@Path("/countries")
public class CountryController {
//step 1 : create service interface instance var
	ICountryService countryService;
//step 2 : instantiate it in constructor
	public CountryController() {
		countryService= new CountryServiceImpl();
	}
	//as we are restrictrited to download any file
	//that's why it is not downloading json data
	/*@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Country> getCountries(){
		List<Country> countryList=countryService.getAllCountries();
		return countryList;
	}*/
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCountries(){
		List<Country> countryList=
				countryService.getAllCountries();
		return countryList.toString();
	}
	@GET
	@Path("/{countryId}")// country ID
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes
	public String getCountryById(
			@PathParam("countryId") int countryId){
return countryService.getCountry(countryId).toString();
	}
	@POST
	@Path("/add")
	@Consumes
	@Produces
	public Response addCountry(
			@FormParam("txtId") int countryId,
			@FormParam("txtName") String countryName,
			@FormParam("txtPopulation") long population
			) 
	{		
		Country country = new Country();
		country.setCountryId(countryId);
		country.setCountryName(countryName);
		country.setPopulation(population);
		System.out.println("Country added  : "+country);
		countryService.addCountry(country);
		return Response.status(200)
				.entity(country.toString()).build();
		
	}
	
	@POST
	@Path("/delete")// country ID
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes
	public String deleteCountryById(
			@FormParam("txtId") int countryId){
		Country country = 
		countryService.deleteCountry(countryId);
		String message="Sorry Boss! Country not in this planet";
		if(country!=null) {
			 message= country 
						+"successfully Deteled";
		}
		return message;
	}
	@PUT
	@Path("/edit")
	@Consumes
	@Produces
	public Response editCountry(
			@FormParam("txtId") int countryId,
			@FormParam("txtName") String countryName,
			@FormParam("txtPopulation") long population
			) 
	{		
		Country country = countryService.getCountry(countryId);
		if(country!=null) {
		//country.setCountryId(countryId);
		country.setCountryName(countryName);
		country.setPopulation(population);
		countryService.updateCountry(country);
		System.out.println("Country Updated  : "+country);
		return Response.status(200)
				.entity(country.toString()).build();
		}else {
			System.out.println("Country NOT Found  with country ID : "+countryId);
			return Response.status(404)
					.entity(null).build();
		}		
		
		
	}
}
