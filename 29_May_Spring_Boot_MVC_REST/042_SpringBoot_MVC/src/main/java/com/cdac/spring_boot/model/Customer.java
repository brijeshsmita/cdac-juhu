/**
 * 
 */
package com.cdac.spring_boot.model;

/**
 * @author Smita B Kumar
 *CREATE TABLE `BOOT_CUSTOMER` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`customerName` varchar(255) DEFAULT NULL,
`email` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
)
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/*
 * This is our model class and it corresponds to Customer table in database
 */
@Entity
@Table(name="BOOT_CUSTOMER")
public class Customer{
 
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
 
	@Column(name="customer_Name")
	String customerName; 
 
	@Column(name="email")
	String email;
 
	public Customer() {
		super();
	}
	public Customer(String customerName,String email) {
		super();
		this.customerName=customerName;
		this.email=email;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
