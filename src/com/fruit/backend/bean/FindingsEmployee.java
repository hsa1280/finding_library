package com.fruit.backend.bean;

public class FindingsEmployee {
	
	private int findingId;
	
	private int employeeId;
	
	public FindingsEmployee() {
		super();
	}
	
	public FindingsEmployee( int findingId, int employeeId ){
		this.findingId = findingId;
		this.employeeId = employeeId;
	}

	public int getFindingId() {
		return findingId;
	}

	public void setFindingId(int findingId) {
		this.findingId = findingId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "FindingEmployee [findingId=" + findingId + ", employeeId="
				+ employeeId + "]";
	}
	
}
