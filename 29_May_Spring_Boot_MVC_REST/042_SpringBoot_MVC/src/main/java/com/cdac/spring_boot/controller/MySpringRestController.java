/**
 * 
 */
package com.cdac.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Smita B Kumar
 *
 */
@RestController
public class MySpringRestController {//Employee
	//DI for JDBCTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;//Address	
	
	//SessionFactory;
	// http://localhost:8080/insert
	@RequestMapping("/insert")
	public String insertData() {
		jdbcTemplate.execute("insert into MY_BOOT_USER(username,email)"
		 		+ "values('cdac','java@cdac.com')");
		return "data inserted Successfully";
		
		//sessionFactory.save(userObject);
	}
	

}
