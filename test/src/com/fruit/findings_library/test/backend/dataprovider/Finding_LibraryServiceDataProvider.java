package src.com.fruit.findings_library.test.backend.dataprovider;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import src.com.fruit.findings_library.test.factory.config.ObjectFactoryConfiguration;
import src.com.fruit.findings_library.test.factory.impl.EmployeeObjectFactory;
import src.com.fruit.findings_library.test.factory.impl.FindingObjectFactory;

import com.fruit.backend.Employee;
import com.fruit.backend.service.impl.FindingLibraryService;
import com.fruit.config.ServiceConfig;

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
	
	private int employeeId = 22;
	
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
