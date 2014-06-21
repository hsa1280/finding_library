package com.fruit.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fruit.backend.Finding;

public class FindingResultSetExtractor implements ResultSetExtractor<Finding> {

	@Override
	public Finding extractData(ResultSet rs) throws SQLException,DataAccessException {

		Finding finding = new Finding();
		finding.setId( rs.getInt( "ID") );
		finding.setDescription( rs.getString("DESCRIPTION") );
		finding.setfType( rs.getString( "F_TYPE") );
		finding.setApproved( rs.getBoolean( "APPROVED" ));
		
		return finding;
	}

	
}
