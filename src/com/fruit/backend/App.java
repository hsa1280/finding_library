package com.fruit.backend;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fruit.DAO.impl.FindingDAOImpl;
import com.fruit.config.FindingImplConfig;

public class App {
	
	public static void main(String args[] ) throws Exception {
		
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml");
		
		/*----------------------Test Employee----------------------------------*/
		
//		IPreparedStatementEmployeeDAO employeeDAO = (IPreparedStatementEmployeeDAO)context.getBean("employeeDAO"); 
//		
//		Employee employee1 = new Employee(123, "shian", "Huang", "shianhuang@ufl.edu" );
//		
//		employeeDAO.insert(employee1);
//		
//		Employee employee2 = employeeDAO.findById(8);
//		
//		System.out.println( employee2 );
//		
//		IJDBCEmployeeDAO jdbcEmployeeDAOImpl = (IJDBCEmployeeDAO)context.getBean("jdbcEmployeeDAO");
//		Employee employee3 = new Employee(456, "Bob", "Gailey", "Bob@ufl.edu" );
//		jdbcEmployeeDAOImpl.insert(employee3);
//		
//		Employee employee4 = jdbcEmployeeDAOImpl.findById(9);
//		
//		System.out.println(employee4);
//		
//		List<Employee> employees = jdbcEmployeeDAOImpl.findAll();
//		
//		for( Employee employee : employees ){
//			System.out.println(employee);
//		}
//		
//		System.out.println();
//		
//		jdbcEmployeeDAOImpl.deleteById(9);
//		
//		employees = jdbcEmployeeDAOImpl.findAll();
//		
//		for( Employee employee : employees ){
//			System.out.println(employee);
//		}
//		
//		String firstName = jdbcEmployeeDAOImpl.findFirstNameById(11);
//		
//		System.out.println( firstName );
		
		/*----------------------Test Finding----------------------------------*/
		
//		IJDBCFindingDAO jdbcFindingDAO = (IJDBCFindingDAO)context.getBean("jdbcFindingDAO");
		
//		Finding finding = new Finding("First finding", "Finding", true);
//		
//		jdbcFindingDAO.insert(finding);
		
//		Finding finding = jdbcFindingDAO.findById(12);
//		
//		System.out.println(finding);
		
//		List<Finding> findings = jdbcFindingDAO.findAll();
//		
//		for( Finding f : findings ){
//			System.out.println(f);
//		}
//		
//		System.out.println();
//		
//		jdbcFindingDAO.deleteById(12);
//		
//		findings = jdbcFindingDAO.findAll();
//		
//		for( Finding f : findings ){
//			System.out.println(f);
//		}
		
//		context.close();
		
//		ApplicationContext ctx = new AnnotationConfigApplicationContext( EmployeeImplConfig.class);
//		
//		EmployeeDAOImpl employeeImpl = (EmployeeDAOImpl)ctx.getBean(EmployeeDAOImpl.class );
		
//		Employee employee3 = new Employee(456, "Bob", "Gailey", "Bob@ufl.edu" );
//		
//		employeeImpl.insert(employee3);
		
//		System.out.println(employeeImpl.findFirstNameById(7));
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(FindingImplConfig.class);
		
		FindingDAOImpl findingDAOImpl = ctx.getBean(FindingDAOImpl.class);
		
//		Finding finding = new Finding(1, "good", "finding", true, 12, new Date(), new Date(), "Shian", "Shian");
//		
//		findingDAOImpl.insert(finding);
		
		System.out.println(findingDAOImpl.findById(21));

		//test change
		
		
		
	}
}
