package com.cdac.hibernate.oto.entities;
/** * @author Smita * */
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "TRAINEE_OTO")
public class Trainee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "trainee_id")
	@GeneratedValue
	private Integer traineeId;

	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="cell_phone")
	private String cellphone;
//mappedBy trainee property created in address class
	@OneToOne(mappedBy="trainee", 	cascade=CascadeType.ALL)
	private Address address;
	//In trainee table we will have a FK of traineeId to make OTO mapping
	
	public Trainee() {
		// TODO Auto-generated constructor stub
	}
	public Integer getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", birthDate=" + birthDate + ", cellphone=" + cellphone + ", address=" + address + "]";
	}
	public Trainee(Integer traineeId, String firstname, String lastname, Date birthDate, String cellphone,
			Address address) {
		super();
		this.traineeId = traineeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
		this.cellphone = cellphone;
		this.address = address;
	}

}