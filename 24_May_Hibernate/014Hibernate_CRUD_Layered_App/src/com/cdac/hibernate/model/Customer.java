/**
 * 
 */
package com.cdac.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Smita B Kumar
 *
 */
@Entity
@Table(name="CDAC_CUSTOMER_HB")
public class Customer {
	@Id
	@Column(name="CUST_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer custId;
	
	@Column(name="CUST_NAME")
	private String custName;
	private String email;
	private String phone;
	//getters and setters
	//no-arg constructors
	//overloaded constructor without id
	//toString method
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer( String custName, String email, String phone) {
		super();
		this.custName = custName;
		this.email = email;
		this.phone = phone;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", email=" + email + ", phone=" + phone + "]";
	}
}






