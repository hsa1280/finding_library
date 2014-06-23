package com.fruit.test.factory.impl;

import java.util.Date;

import com.fruit.backend.Finding;
import com.fruit.test.factory.AbstractObjectFactory;

public class FindingObjectFactory extends AbstractObjectFactory<Finding> {

	@Override
	protected void setupNonPersistedList() throws Exception {
		
		if( nonPersistedObjectList.size() == 0 ) {
			
			for( int i = 1; i <= 10; i++) {
				nonPersistedObjectList.add( new Finding( "Finding" + i, "F", true, i, new Date(), new Date(), "Shian" + i, "Shian" + i));
			} 
		}
	}

	@Override
	protected boolean compare(Finding obj1, Finding obj2) {
		
		return false;
	}

	
}
