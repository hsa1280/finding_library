package com.fruit.DAO;

import java.util.List;

import com.fruit.backend.Employee;

public interface IJDBCEmployeeDAO {

	public void insert(Employee employee);
	
	public Employee findById( int id );
	
	public List<Employee> findAll();
	
	public void deleteById( int id );
	
	public String findFirstNameById( int id );
}
