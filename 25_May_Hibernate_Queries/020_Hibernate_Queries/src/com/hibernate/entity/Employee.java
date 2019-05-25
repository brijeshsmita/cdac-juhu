/**
 * 
 */
package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Smita
 *
 */
//prep work Step 1: annotate the enitity class as @Entity
@Entity
@Table(name="myemp_9")
public class Employee implements Serializable{
	private static final long serialVersionUID = -8813677613971688441L;

	//Primary key
	//Generators - Sequence,Table,Auto,Assigned
	
	@Id
	/*@SequenceGenerator(name="EMP_GEN",sequenceName="SEQ_MYEMP_9",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="EMP_GEN")*/
	@GeneratedValue(strategy=GenerationType.AUTO)//detect the native db and will auto-generate the id using the specific db strategy
	@Column(name="eid")
	private Integer empId;
	
	@Column(name="ename")
	private String empName;
	
	@Column(name="esal")
	private Double empSal;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	public Employee(Integer empId, String empName, Double empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
	}
	public Employee(String empName, Double empSal) {
		super();
		this.empName = empName;
		this.empSal = empSal;
	}
}
