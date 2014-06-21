package com.fruit.backend;

import java.util.Date;

public class Finding {

	private int id;
	
	private String description;
	
	private String fType;	//this should be a enum type
	
	private boolean approved;
	
	private int manufacturerId;	//put a forgeign key reference here
	
	private Date createDate;
	
	private Date lastUpdateDate;
	
	private String createUser;
	
	private String lastUpdateUser;
	
	public Finding() {
		super();
	}
	
	public Finding( int id, String desciption, String fType, boolean approved ) {
		
		//this.id = id;
		this.description = desciption;
		this.fType = fType;
		this.approved = approved;
	}
	
	public Finding(int id, String description, String fType, boolean approved,
			int manufacturerId, Date createDate, Date lastUpdateDate,
			String createUser, String lastUpdateUser) {
		super();
		this.id = id;
		this.description = description;
		this.fType = fType;
		this.approved = approved;
		this.manufacturerId = manufacturerId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getfType() {
		return fType;
	}

	public void setfType(String fType) {
		this.fType = fType;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
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
		return "Finding [id=" + id + ", description=" + description
				+ ", fType=" + fType + ", approved=" + approved
				+ ", manufacturerId=" + manufacturerId + ", createDate="
				+ createDate + ", lastUpdateDate=" + lastUpdateDate
				+ ", createUser=" + createUser + ", lastUpdateUser="
				+ lastUpdateUser + "]";
	}
	
}
