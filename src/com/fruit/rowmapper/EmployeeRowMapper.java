package com.fruit.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fruit.backend.bean.Employee;
import com.fruit.extractor.EmployeeResultSetExtractor;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int line) throws SQLException {
		
		EmployeeResultSetExtractor employeeResultSetExtractor = new EmployeeResultSetExtractor();
		return employeeResultSetExtractor.extractData(rs);
	}

	
}
