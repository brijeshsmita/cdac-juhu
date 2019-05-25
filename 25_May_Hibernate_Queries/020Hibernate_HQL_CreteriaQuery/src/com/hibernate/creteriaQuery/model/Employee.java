package com.hibernate.creteriaQuery.model;
/**
 * 
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;/** * @author SMita * */

@Entity
@Table(name="lnt_Employee123")
public class Employee implements Serializable{

	/*MySql
	 * create table lnt_Employee123
	  (emp_id integer,
	  first_name varchar(30) primary key,
	  last_name varchar(30),
	  salary double,
	  phone_no varchar(30),
	  email varchar(30));*/
	/*Oracle
	 * create table lnt_Employee123
	  (emp_id number,
	  first_name varchar2(30) primary key,
	  last_name varchar2(30),
	  salary number,
	  phone_no varchar2(30),
	  email varchar2(30));*/
	private static final long serialVersionUID = 1L;
	//marker/tagging interface in java which does not contain any method
	//use to just inform the jvm that specific class has this implemented and the obj need to be serialized
	//if not implemented then throws NotSerializableException 
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Emp_Gen")
	@SequenceGenerator(name="Emp_Gen", sequenceName="seq_lnt_Employee" ,allocationSize=1)
	@Column(name="emp_Id")
	private Long empId;//avoid using  primitive data types as it can't be validated in future
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_Name")
	private String lastName;
	
	@Column(name="salary")
	private Double salary;
	
	@Column(name="phone_No")
	private String phoneNo;
	
	private String email;
	private Date doj;//date of joining
	//step 4 : private static variables
	private static Long numId;//automatic id generation
	//step 5 : static initializer block
	static {
		System.out.println("****Static Initializer Block**** executed only once and before constuctor");
		//automatic id generation
		numId=10000+(long) (Math.random()*122.123);//explicitly type cast long to Long
	}
	//step 6: initializer block
	{
		System.out.println("****Initializer Block****executed for every object and before constuctor");
		empId=numId;//assigned the auto-generated numId to custId
	}
	public Employee() {
		System.out.println("****no_arg Employee constuctor ****executed for every object created using default constructor ");
	}
	public Employee(String firstName, String lastName,Double salary, String phoneNo, String email, Date doj) {
		System.out.println("****Overloaded Employee constuctor ****executed for every object created using Overloaded constructor ");

		this.firstName = firstName;
		this.lastName = lastName;
		this.salary=salary;
		this.phoneNo = phoneNo;
		this.email = email;
		this.doj = doj;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", phoneNo=" + phoneNo + ", email=" + email + ", doj=" + doj + "]";
	}
	//generate getters and setters
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}

}
