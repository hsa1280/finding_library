package com.fruit.test.backend.dataprovider;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.fruit.backend.bean.Employee;
import com.fruit.backend.bean.Finding;
import com.fruit.backend.service.impl.FindingLibraryService;
import com.fruit.config.ServiceConfig;
import com.fruit.test.factory.config.ObjectFactoryConfiguration;
import com.fruit.test.factory.impl.EmployeeObjectFactory;
import com.fruit.test.factory.impl.FindingObjectFactory;

@ContextConfiguration(
		classes = {
			ObjectFactoryConfiguration.class,
			ServiceConfig.class
		}
)

public class Finding_LibraryServiceDataProvider extends AbstractTestNGSpringContextTests {

	@Autowired
	private FindingLibraryService findingLibraryService;
	
	@Autowired
	private EmployeeObjectFactory employeeObjectFactory;
	
	@Autowired
	private FindingObjectFactory findingObjectFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	String USERNAME = "Shian";
	
	@BeforeClass
	public void beforeClassParent() throws Exception {
		
		deleteAllData();

	}

	@AfterClass
	public void afterClassParent() throws Exception {
		
		//deleteAllData();
	}
	
	protected void deleteAllData()
	{
		getJdbcTemplate().execute( "delete from employees where create_user = '" + USERNAME + "'");
		getJdbcTemplate().execute( "delete from findings where create_user = '" + USERNAME + "'");
	}
	/****************************Employee DataProviders************************************/
	
	@DataProvider( name = "saveEmployee" )
	public Object[][] saveEmployee() throws Exception {
		
		List<Employee> employees = getEmployeeObjectFactory().getAllNonPersisted();
		
		return objectListToObjectArray(employees);
	}
	
	@DataProvider( name = "getEmployeeById")
	public Object[][] getEmployeeByid() throws Exception {
		
		List<Employee> employees = getFindingLibraryService().getAllEmployees();
		
		return new Object[][] {
				new Object[] { employees.get(1).getId() }
		};
	}
	
	@DataProvider( name = "getEmployees")
	public Object[][] getEmployees() throws Exception {
		
		return new Object[][] {
				new Object[]{}
		};
	}
	
	@DataProvider( name = "deleteEmployeeById") 
	public Object[][] deleteById() throws Exception {
		
		List<Employee> employees = getFindingLibraryService().getAllEmployees();
		
		return new Object[][] {
			new Object[] { employees.get(1).getId()  }
		};
	}
	
	/****************************Finding DataProviders************************************/
	@DataProvider( name = "saveFinding")
	public Object[][] saveFinding() throws Exception {
		
		List<Finding> findings = getFindingObjectFactory().getAllNonPersisted();
		
		return objectListToObjectArray(findings);
	}
	
	@DataProvider( name = "getFindingById" )
	public Object[][] getFindingById() throws Exception {
		
		List<Finding> findings = getFindingLibraryService().getAllFindings();
		
		return new Object[][] {
			new Object[] { findings.get(1).getId()}
		};
	}
	
	@DataProvider( name = "getAllFindings" )
	public Object[][] getAllFindings() throws Exception {
		
		return new Object[][] {
			new Object[]{}
		};
	}
	
	@DataProvider( name = "deleteFindingById" ) 
	public Object[][] deleteFindingById() throws Exception {
		
		List<Finding> findings = getFindingLibraryService().getAllFindings();
		
		return new Object[][] {
			new Object[] { findings.get(1).getId()}
		};
	}
	
	public EmployeeObjectFactory getEmployeeObjectFactory() {
		return employeeObjectFactory;
	}

	public void setEmployeeObjectFactory(EmployeeObjectFactory employeeObjectFactory) {
		this.employeeObjectFactory = employeeObjectFactory;
	}

	public FindingObjectFactory getFindingObjectFactory() {
		return findingObjectFactory;
	}

	public void setFindingObjectFactory(FindingObjectFactory findingObjectFactory) {
		this.findingObjectFactory = findingObjectFactory;
	}

	public FindingLibraryService getFindingLibraryService() {
		return findingLibraryService;
	}

	public void setFindingLibraryService(FindingLibraryService findingLibraryService) {
		this.findingLibraryService = findingLibraryService;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected <T> Object[][] objectListToObjectArray( Collection<T> collection ) {
		Object[][] objArray = null;

		if( collection != null )
		{
			objArray = new Object[collection.size()][1];

			int i = 0;

			for( T obj : collection )
			{
				objArray[i][0] = obj;

				i++;

			}

		}

		return objArray;

	}
	
}
