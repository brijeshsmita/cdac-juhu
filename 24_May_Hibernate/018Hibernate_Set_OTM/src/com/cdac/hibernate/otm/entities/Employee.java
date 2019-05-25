package com.cdac.hibernate.otm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMP_OTM")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMP_ID")
	private int empId;
	
	@Column(name="EMP_NAME")
	private String empName;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Department department;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", department=" + department
				+ "]";
	}

	public Employee(String empName, double salary, Department department) {
		super();
		this.empName = empName;
		this.salary = salary;
		this.department = department;
	}

	public Employee(int empId, String empName, double salary, Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.department = department;
	}
}
