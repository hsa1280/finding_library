package com.fruit.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fruit.DAO.impl.EmployeeDAOImpl;
import com.fruit.DAO.impl.FindingDAOImpl;
import com.fruit.backend.bean.Employee;
import com.fruit.backend.bean.Finding;
import com.fruit.backend.service.IFindingLibraryService;

@Service
public class FindingLibraryService implements IFindingLibraryService{

	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;
	
	@Autowired
	private FindingDAOImpl findingDAOImpl;
	
	@Override
	public void saveEmployee(Employee employee) throws Exception {

		getEmployeeDAOImpl().insert(employee);
	}

	@Override
	public Employee getEmployeeById(int id) throws Exception {
		
		return getEmployeeDAOImpl().findById(id);
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {

		return getEmployeeDAOImpl().findAll();
	}

	@Override
	public void deleteEmployeeById(int id) throws Exception {

		getEmployeeDAOImpl().deleteById(id);
	}
	

	@Override
	public void saveFinding(Finding finding) throws Exception {

		getFindingDAOImpl().insert(finding);
	}

	@Override
	public Finding getFindingById(int id) throws Exception {
		
		return getFindingDAOImpl().findById(id);
	}

	@Override
	public List<Finding> getAllFindings() throws Exception {
	
		return getFindingDAOImpl().findAll();
	}

	@Override
	public void deleteFindingById(int id) throws Exception {

		getFindingDAOImpl().deleteById(id);
	}

	public EmployeeDAOImpl getEmployeeDAOImpl() {
		return employeeDAOImpl;
	}

	public void setEmployeeDAOImpl(EmployeeDAOImpl employeeDAOImpl) {
		this.employeeDAOImpl = employeeDAOImpl;
	}

	public FindingDAOImpl getFindingDAOImpl() {
		return findingDAOImpl;
	}

	public void setFindingDAOImpl(FindingDAOImpl findingDAOImpl) {
		this.findingDAOImpl = findingDAOImpl;
	}
	
}
