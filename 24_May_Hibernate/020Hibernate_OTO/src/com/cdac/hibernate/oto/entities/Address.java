package com.cdac.hibernate.oto.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
/**
 * @author Smita
 *
 */
@Entity
@Table(name="ADDRESS_OTO")
public class Address {
	
	@Id
	private Integer addressId;
	
	@Column(name="street")
	private String street;

	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;

	@Column(name="country")
	private String country;

	@OneToOne
	@JoinColumn(name="trainee_id")
	private Trainee trainee;

	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(Integer addressId, String street, String city, String state, String country) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + "]";
	}


}
