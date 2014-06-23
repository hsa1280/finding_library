package com.fruit.DAO.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fruit.DAO.IFindingDAO;
import com.fruit.backend.bean.Finding;
import com.fruit.rowmapper.FindingRowMapper;

public class FindingDAOImpl implements IFindingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(Finding finding) {
		
		String sql = "INSERT INTO FINDINGS( ID, DESCRIPTION, F_TYPE, APPROVED,MANUFACTURER_ID, CREATE_DATE, CREATE_USER, LAST_UPDATE_DATE, LAST_UPDATE_USER ) VALUES( ?,?,?,?,?,?,?, ?, ?)";
		
		jdbcTemplate.update(sql, new Object[] { finding.getId(),finding.getDescription(), finding.getfType(), finding.isApproved(),finding.getManufacturerId(),finding.getCreateDate(),finding.getCreateUser(), finding.getLastUpdateDate(), finding.getLastUpdateUser()});
	}

	@Override
	public Finding findById(int id) {

		String sql = "SELECT * FROM FINDINGS WHERE ID = ?";
		
		Finding finding = jdbcTemplate.queryForObject(sql, new Object[]{ id }, new FindingRowMapper());
		return finding;
	}

	@Override
	public List<Finding> findAll() {

		String sql = "SELECT * FROM FINDINGS";
		
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
		
		jdbcTemplate.update(sql, new Object[]{ id });
	}
	
	
}
