package src.com.fruit.test.backend.service;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import src.com.fruit.test.backend.dataprovider.Finding_LibraryServiceDataProvider;

import com.fruit.backend.Employee;

public class FindingLibraryTest extends Finding_LibraryServiceDataProvider {

	@BeforeMethod( alwaysRun = true )
	public void beforeMethod( Method m )
	{
		System.out.println( "****************** Starting test: " + m.getName() + "*************************" );
	}
	
	@AfterMethod( alwaysRun = true )
	public void afterMethod( Method m )
	{
		System.out.println( "****************** Finished test: " + m.getName() + "*************************" );
		System.out.println();
	}
	
	/****************************Employee Test*********************************/
	@Test(dataProvider = "saveEmployee" , groups = { "saveEmployee" })
	public void testSaveEmployee( Employee employee ) throws Exception {
		
		getFindingLibraryService().saveEmployee(employee);
		
		getEmployeeObjectFactory().addPersisted(employee);
	}
	
	@Test( dataProvider = "getEmployeeById", groups = { "getEmployeeById"}, dependsOnGroups = { "saveEmployee"} )
	public void testGetEmployeeById( int id ) throws Exception {
		
		Employee employee = getFindingLibraryService().getEmployeeById(id);
		
		Assert.assertNotNull(employee);
		Assert.assertEquals(id, employee.getId());
	}
	
	@Test( dataProvider = "getEmployees", groups = { "getEmployees"}, dependsOnGroups = { "saveEmployee"} )
	public void testGetEmployees() throws Exception {
		
		List<Employee> employees = getFindingLibraryService().getAllEmployees();
		
		Assert.assertTrue( employees.size() > 0);
		Assert.assertNotNull(employees);
		
		for( Employee employee : employees ) {
			
			System.out.println( employee );
		}
	}
	
//	@Test( dataProvider = "deleteEmployeeById", groups = { "deleteEmployeeById" }, dependsOnGroups = { "getEmployeeById"})
//	public void testDeleteEmployeeById( int id ) throws Exception {
//		
//		getFindingLibraryService().deleteEmployeeById(id);
		
//		Employee employee = getFindingLibraryService().getEmployeeById(id);
//		
//		Assert.assertNotNull( employee);
//	}
}
