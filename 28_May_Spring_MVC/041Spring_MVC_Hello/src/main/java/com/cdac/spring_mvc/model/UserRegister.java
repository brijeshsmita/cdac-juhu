package com.cdac.spring_mvc.model;

public class UserRegister {
	private String username;
	private String password;
	private String name;
	private String address;
	private String country;
	private String zip;
	private String email;
	private String gender;
	private String english;
	private String nonenglish;
	private String description;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getNonenglish() {
		return nonenglish;
	}
	public void setNonenglish(String nonenglish) {
		this.nonenglish = nonenglish;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "UserRegister [username=" + username + ", password=" + password
				+ ", name=" + name + ", address=" + address + ", country="
				+ country + ", zip=" + zip + ", email=" + email + ", gender="
				+ gender + ", english=" + english + ", nonenglish="
				+ nonenglish + ", description=" + description + "]";
	}	
}
