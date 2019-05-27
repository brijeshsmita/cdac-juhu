/**
 * 
 */
package com.cdac.spring.cab.service;

/**
 * @author Smita B Kumar
 *
 */
public class UberCabService implements ICabService {
	private String name;
	/**
	 * 
	 */
	public UberCabService() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.cdac.spring.cab.service.ICabService#bookCab(java.lang.String)
	 */
	@Override
	public String bookCab(String name) {
		// TODO Auto-generated method stub
		return "UberCab Booked for : "+name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
