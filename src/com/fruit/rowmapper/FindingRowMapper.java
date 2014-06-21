package com.fruit.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fruit.backend.Finding;
import com.fruit.extractor.FindingResultSetExtractor;

public class FindingRowMapper implements RowMapper<Finding> {

	@Override
	public Finding mapRow(ResultSet rs, int line) throws SQLException {
		
		FindingResultSetExtractor frs = new FindingResultSetExtractor();
		
		return frs.extractData(rs);
	}

	
}
