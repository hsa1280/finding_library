package com.fruit.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fruit.backend.Employee;

public class EmployeeResultSetExtractor implements ResultSetExtractor< Employee > {

	@Override
	public Employee extractData( ResultSet rs ) throws SQLException,DataAccessException {

		Employee employee = new Employee();
		employee.setId(rs.getInt("ID"));
		employee.setFirstName( rs.getString("FIRST_NAME"));
		employee.setLastName(rs.getString("LAST_NAME"));
		employee.setEmail(rs.getString("EMAIL"));
		
		return employee;
	}

	
}
