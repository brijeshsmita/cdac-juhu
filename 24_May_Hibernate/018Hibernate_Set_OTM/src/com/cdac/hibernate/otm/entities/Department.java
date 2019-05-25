package com.cdac.hibernate.otm.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPT_OTM")
public class Department {
/*
 * create table DEPT_MASTER
 * (id NUMBER PRIMARY KEY,
 * name VARCHAR2(20);
 * 
 * INSERT INTO DEPT_MASTER VALUES(10,'IT');
 */
	@Id
	@Column(name="DEPT_ID")
	private int deptId;
	
	@Column(name="DEPT_NAME")
	private String deptName;
	
//mappedBy property "department" of Employee class
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();		
	//Initialization required to avoid NullPointerException

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName +"]";
	}

public Department() {
	// TODO Auto-generated constructor stub
}
	public Department(String deptName, Set<Employee> employees) {
		super();
		this.deptName = deptName;
		this.employees = employees;
	}


	public Department(int deptId, String deptName, Set<Employee> employees) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.employees = employees;
	}


	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
