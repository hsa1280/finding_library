package com.fruit.DAO;
import com.fruit.backend.bean.Employee;


public interface IPreparedStatementEmployeeDAO {

	public void insert( Employee employee );
	
	public Employee findById( int id );
}
