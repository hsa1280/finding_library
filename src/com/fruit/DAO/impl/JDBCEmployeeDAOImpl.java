package com.fruit.DAO.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fruit.DAO.IJDBCEmployeeDAO;
import com.fruit.backend.bean.Employee;
import com.fruit.rowmapper.EmployeeRowMapper;

public class JDBCEmployeeDAOImpl implements IJDBCEmployeeDAO {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource( DataSource dataSource ) {
		
		this.dataSource = dataSource;
	}
	
	@Override
	public void insert(Employee employee) {
		
		String sql = "INSERT INTO EMPLOYEES(FIRST_NAME, LAST_NAME,EMAIL) VALUES(?,?,?)";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql, new Object[] { employee.getFirstName(), employee.getLastName(), employee.getEmail()});
	}

	@Override
	public Employee findById(int id) {
	
		String sql = "SELECT * FROM EMPLOYEES WHERE ID = ?";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		Employee employee = (Employee)jdbcTemplate.queryForObject(sql, new Object[] {id}, new EmployeeRowMapper());
		
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "SELECT * FROM EMPLOYEES";
		
		List<Employee> employees = new ArrayList<Employee>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> row : rows) {
			
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			employee.setFirstName((String)row.get("FIRST_NAME"));
			employee.setLastName((String)row.get("LAST_NAME"));
			employee.setEmail((String)row.get("EMAIL"));
			employees.add(employee);
		}
		return employees;
	}
	
	@Override
	public void deleteById( int id ){
		
		String sql = "DELETE FROM EMPLOYEES WHERE ID = ?";
		
		jdbcTemplate = new JdbcTemplate( dataSource);
		
		jdbcTemplate.update(sql, new Object[]{ id });
	}
	
	@Override
	public String findFirstNameById( int id ) {
		
		String sql = "SELECT FIRST_NAME FROM EMPLOYEES WHERE ID = ?";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		String firstName = jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
		
		return firstName;
	}

	
}
