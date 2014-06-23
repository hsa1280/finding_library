package com.fruit.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.fruit.DAO.IPreparedStatementEmployeeDAO;
import com.fruit.backend.bean.Employee;

public class PreparedStatementEmployeeDAOImpl implements IPreparedStatementEmployeeDAO {

	private DataSource dataSource;
	
	public void setDataSource( DataSource dataSource) {
		
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Employee employee) {

		String sql = "INSERT INTO EMPLOYEES " + 
				"( FIRST_NAME, LAST_NAME, EMAIL )"
				+ " VALUES ( ?, ?, ? )";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString( 1, employee.getFirstName() );
			ps.setString( 2, employee.getLastName() );
			ps.setString( 3, employee.getEmail() );
			ps.executeUpdate();
			ps.close();
			
		} catch( SQLException e ){
			
			System.out.println( e );
	
		} finally {
			
			if( conn != null ){
				try{
					conn.close();
				} catch (Exception e){
					
				}
			}
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Employee findById(int id) {

		String sql = "SELECT * FROM EMPLOYEES WHERE ID = ?";
		
		Connection conn = null; 
		
		Employee employee = null;
		
		try {
			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1, id );
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				
//				employee = new Employee(
//						rs.getInt("ID"),
//						rs.getString( "FIRST_NAME" ),
//						rs.getString( "LAST_NAME" ),
//						rs.getString( "EMAIL" )
//						);
			}
			rs.close();
			ps.close();
		} 
		catch ( SQLException e) {
			
			System.out.println(e);
		} 
		finally {
			if( conn != null ) {
				try {
					conn.close();
				} catch (SQLException e) {
					
				} 
			}
			return employee;
		}
	}
	
	
}
