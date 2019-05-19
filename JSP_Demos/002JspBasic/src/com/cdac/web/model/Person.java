/**
 * 
 */
package com.cdac.web.model;

/**
 * @author Smita B Kumar
 *
 */
public class Person {
	private String name;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}
