package com.manh.lm.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name="employee")
public class Employee implements Serializable {

	
	private static final long serialVersionUID = -5568082383511503104L;
	private Integer employeeId;
	private String name;
	private String email;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer employeeId, String name, String email) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
