/**
 * 
 */
package com.cdac.hibernate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Smita
 *
 */
@Entity
@Table(name="SMGR_TPC")
@AttributeOverrides({  
	@AttributeOverride(name="empId",column=@Column(name="EMP_ID")),
	@AttributeOverride(name="empName",column=@Column(name="EMP_NAME")),
	@AttributeOverride(name="empSal",column=@Column(name="EMP_SAL")),  
    @AttributeOverride(name="bonus", column=@Column(name="BONUS")) })   

public class SalesManager extends Manager {	
	@Column(name="COMM")
	private double comm;
	
	//no-arg constructor, Overloaded constructor
	//toString() method, setters and setters
	public SalesManager() {
		// TODO Auto-generated constructor stub
	}	
	public SalesManager(Long empId, String empName, Double empSal, Double bonus, double comm) {
		super(empId, empName, empSal, bonus);
		this.comm = comm;
	}
	public SalesManager(String empName, Double empSal, Double bonus, double comm) {
		super(empName, empSal, bonus);
		this.comm = comm;
	}
	@Override
	public Double getEmpSal() {
		// TODO Auto-generated method stub
		return super.getEmpSal()+comm;
	}
	@Override
	public String toString() {
		return "SalesManager [comm=" + comm + ", toString()=" + super.toString() + "]";
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
}
