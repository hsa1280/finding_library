package com.fruit.backend.bean;

import java.util.Date;

public class Employee {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Date createDate;
	
	private Date lastUpdateDate;
	
	private String createUser;
	
	private String lastUpdateUser;
	
	public Employee() {
		super();
	}
	
	public Employee( String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Employee( String firstName, String lastName, String email,
			Date createDate, Date lastUpdateDate, String createUser,
			String lastUpdateUser) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createDate = createDate;
		this.lastUpdateDate = lastUpdateDate;
		this.createUser = createUser;
		this.lastUpdateUser = lastUpdateUser;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email
				+ ", createDate=" + createDate + ", lastUpdateDate="
				+ lastUpdateDate + ", createUser=" + createUser
				+ ", lastUpdateUser=" + lastUpdateUser + "]";
	}
	
}
