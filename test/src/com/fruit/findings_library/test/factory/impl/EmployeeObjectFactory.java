package src.com.fruit.findings_library.test.factory.impl;

import java.util.Date;

import src.com.fruit.findings_library.test.factory.AbstractObjectFactory;

import com.fruit.backend.Employee;

public class EmployeeObjectFactory extends AbstractObjectFactory<Employee> {

	@Override
	protected void setupNonPersistedList() throws Exception {

		if( nonPersistedObjectList.size() == 0 ) {
			
			for( int i = 1; i <= 10; i++ ) {
				nonPersistedObjectList.add( new Employee("Shian" + i, "Huang" + i, "shian.huang@fotlinc.com", new Date(), new Date(), "Shian", "Shian" ) );
			}
			
		}
	}

	@Override
	protected boolean compare(Employee obj1, Employee obj2) {
		
		return false;
	}
	
	

}
