package com.fruit.DAO.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fruit.DAO.IJDBCFindingDAO;
import com.fruit.backend.Finding;
import com.fruit.rowmapper.FindingRowMapper;

public class JDBCFindingDAOImpl implements IJDBCFindingDAO {
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource( DataSource dataSource ) {
		
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Finding finding) {

		String sql = "INSERT INTO FINDINGS( DESCRIPTION, F_TYPE, APPROVED ) VALUES( ?, ?, ?)";
		
		jdbcTemplate = new JdbcTemplate( dataSource );
		
		jdbcTemplate.update(sql, new Object[] { finding.getDescription(), finding.getfType(), finding.isApproved()});
	}

	@Override
	public Finding findById(int id) {

		String sql = "SELECT * FROM FINDINGS WHERE ID = ?";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		Finding finding = (Finding)jdbcTemplate.queryForObject(sql, new Object[] {id}, new FindingRowMapper());
		
		return finding;
	}

	@Override
	public List<Finding> findAll() {

		String sql = "SELECT * FROM FINDINGS";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Finding> findings = new ArrayList<Finding>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		for( Map<String, Object> row : rows ) {
			
			Finding finding = new Finding();
			
			finding.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			finding.setDescription((String)row.get("DESCRIPTION"));
			finding.setfType((String)row.get("F_TYPE"));
			finding.setApproved(Boolean.parseBoolean(String.valueOf(row.get("APPROVED"))));
			
			findings.add(finding);
		}
		return findings;
	}

	@Override
	public void deleteById(int id) {
		
		String sql = "DELETE FROM FINDINGS WHERE ID = ?";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql, new Object[]{ id });
		
	}
	
}
