package com.fruit.DAO.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fruit.DAO.IEmployeeDAO;
import com.fruit.backend.Employee;
import com.fruit.rowmapper.EmployeeRowMapper;

public class EmployeeDAOImpl implements IEmployeeDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(Employee employee) {
		
		String sql = "INSERT INTO EMPLOYEES(FIRST_NAME, LAST_NAME, EMAIL, CREATE_DATE, LAST_UPDATE_DATE, CREATE_USER, LAST_UPDATE_USER) VALUES(?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql, new Object[] { employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getCreateDate(), employee.getLastUpdateDate(), employee.getCreateUser(), employee.getLastUpdateUser()});
		
	}
	
	public Employee findById( int id ) throws Exception {
		
		String sql = "SELECT * FROM EMPLOYEES WHERE ID = ?";
		
		Employee employee = getjdbcTemplate().queryForObject(sql, new Object[] {id}, new EmployeeRowMapper());
		
		return employee;
	}
	

	@Override
	public List<Employee> findAll() {

		String sql = "SELECT * FROM EMPLOYEES";
		
		List<Employee> employees = new ArrayList<Employee>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> row : rows) {
			
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			employee.setFirstName((String)row.get("FIRST_NAME"));
			employee.setLastName((String)row.get("LAST_NAME"));
			employee.setEmail((String)row.get("EMAIL"));
			employee.setCreateDate((Date)row.get("CREATE_DATE"));
			employee.setLastUpdateDate((Date)row.get("LAST_UPDATE_DATE"));
			employee.setCreateUser((String)row.get("CREATE_USER"));
			employee.setLastUpdateUser((String)row.get("LAST_UPDATE_USER"));
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public void deleteById(int id) {

		String sql = "DELETE FROM EMPLOYEES WHERE ID = ?";
		
		jdbcTemplate.update(sql, new Object[]{ id });
	}

	@Override
	public String findFirstNameById(int id) {

		String sql = "SELECT FIRST_NAME FROM EMPLOYEES WHERE ID = ?";
		
		String firstName = jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
		
		return firstName;
	}


	public JdbcTemplate getjdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
