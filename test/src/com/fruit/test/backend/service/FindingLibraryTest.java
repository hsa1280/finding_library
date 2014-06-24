package com.fruit.test.backend.service;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fruit.backend.bean.Employee;
import com.fruit.backend.bean.Finding;
import com.fruit.test.backend.dataprovider.Finding_LibraryServiceDataProvider;

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
	
	@Test( dataProvider = "deleteEmployeeById", groups = { "deleteEmployeeById" }, dependsOnGroups = { "getEmployeeById"})
	public void testDeleteEmployeeById( int id ) throws Exception {
		
		getFindingLibraryService().deleteEmployeeById(id);
		
	}
	
	/****************************Finding Test*********************************/
	@Test( dataProvider = "saveFinding", groups = { "saveFinding"} )
	public void testSaveFinding( Finding finding ) throws Exception {
		
		
		
		
		
		
	}
	
	@Test( dataProvider = "getFindingById", groups = {" getFindingById "}, dependsOnGroups = {"saveFinding"} )
	public void getFindingById( int id ) throws Exception {
		
		Finding finding = getFindingLibraryService().getFindingById(id);
		
		Assert.assertNotNull(finding);
		Assert.assertEquals(id, finding.getId());
	}
	
	@Test( dataProvider = "getAllFindings", groups = {"getAllFindings"}, dependsOnGroups = {"saveFinding"} )
	public void testGetAllFindings() throws Exception {
		
		List<Finding> findings1 = getFindingLibraryService().getAllFindings();
		
		Assert.assertNotNull(findings1);
		Assert.assertTrue( findings1.size() > 0);
		System.out.println("From DB:");
		System.out.println( findings1 );
		
	}
	
	@Test( dataProvider = "deleteFindingById", groups = { "deleteFindingById" }, dependsOnGroups = {"saveFinding"} )
	public void testDeleteFindingById( int id ) throws Exception {
		
		getFindingLibraryService().deleteFindingById(id);
		
		List<Finding> findings1 = getFindingLibraryService().getAllFindings();
		System.out.println("From DB:");
		System.out.println( findings1 );
	}
}
