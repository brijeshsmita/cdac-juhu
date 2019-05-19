/**
 * 
 */
package com.cg.jdbc.emp.dao;

import com.cg.jdbc.emp.model.Employee;

/*@author smita*/
public interface EmployeeDao {
	void addEmployee(Employee e);
	void removeEmployee(Employee e);
	void modifyEmployee(Employee e);
	void searchEmployee(Employee e);
	void listAllEmployee();
}
