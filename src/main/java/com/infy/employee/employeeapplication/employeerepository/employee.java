package com.infy.employee.employeeapplication.employeerepository;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class employee {
	@Id
	private String employeeid;
	private String employeename;
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public employee(String employeeid, String employeename) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	@Override
	public String toString() {
		return "empRepo [employeeid=" + employeeid + ", employeename=" + employeename + "]";
	}
	
	

}
