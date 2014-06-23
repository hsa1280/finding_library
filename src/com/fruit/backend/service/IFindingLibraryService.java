package com.fruit.backend.service;

import java.util.List;

import com.fruit.backend.bean.Employee;
import com.fruit.backend.bean.Finding;

public interface IFindingLibraryService {

	/***********************Employee*************************/
	public void saveEmployee( Employee employee ) throws Exception;
	
	public Employee getEmployeeById( int id ) throws Exception;
	
	public List<Employee> getAllEmployees() throws Exception;
	
	public void deleteEmployeeById( int id ) throws Exception;
	
	/**********************Finding**************************/
	public void saveFinding( Finding finding ) throws Exception;
	
	public Finding getFindingById( int id ) throws Exception;
	
	public List<Finding> getAllFindings() throws Exception;
	
	public void deleteFindingById( int id) throws Exception;
	
}
