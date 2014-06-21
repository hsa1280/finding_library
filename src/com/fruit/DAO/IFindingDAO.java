package com.fruit.DAO;

import java.util.List;

import com.fruit.backend.Finding;

public interface IFindingDAO {

	public void insert( Finding finding);
	
	public Finding findById( int id );
	
	public List<Finding> findAll();
	
	public void deleteById( int id );
}
