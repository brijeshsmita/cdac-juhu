/**
 * 
 */
package com.cdac.hibernate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Smita
 *
 */
@Entity
@DiscriminatorValue(value="MGR")
public class Manager extends Employee {
	@Column(name="BONUS")
	private Double bonus;
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	public Manager( String empName, Double empSal, Double bonus) {
		super(empName, empSal);
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return "Manager [getBonus()=" + getBonus() + ", getEmpSal()=" + getEmpSal() + ", getEmpId()=" + getEmpId()
				+ ", getEmpName()=" + getEmpName() + "]";
	}
	@Override
	public Double getEmpSal() {
		// TODO Auto-generated method stub
		return super.getEmpSal()+bonus;
	}
	
	
}
