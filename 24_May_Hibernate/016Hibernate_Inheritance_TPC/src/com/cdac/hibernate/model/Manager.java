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
@Table(name="MGR_TPC")
@AttributeOverrides({
	//@AttributeOverride(name="empId",column=@Column(name="EMP_ID")),
	@AttributeOverride(name="empName",column=@Column(name="EMP_NAME")),
	@AttributeOverride(name="empSal",column=@Column(name="EMP_SAL"))
})
public class Manager extends Employee {
	public Manager(Long empId, String empName, Double empSal, Double bonus) {
		super(empId, empName, empSal);
		this.bonus = bonus;
	}
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
