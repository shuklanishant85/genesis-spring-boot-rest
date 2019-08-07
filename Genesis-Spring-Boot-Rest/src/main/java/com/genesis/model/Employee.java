package com.genesis.model;

import java.util.Date;

public class Employee {

	private String firstName;
	private String lastName;
	private long id;
	private Date dob;

	public Employee() {

	}

	public Employee(String firstName, String lastName, long id, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
