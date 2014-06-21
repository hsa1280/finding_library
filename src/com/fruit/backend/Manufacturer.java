package com.fruit.backend;

public class Manufacturer {
	
	private int id;
	
	private String manufacturerName;
	
	private String country;
	
	public Manufacturer() {
		
		super();
	}
	
	public Manufacturer( String manufacturerName, String country ){
		
		this.manufacturerName = manufacturerName;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", manufacturerName="
				+ manufacturerName + ", country=" + country + "]";
	}
	
}
