package src.com.fruit.test.factory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import src.com.fruit.test.factory.impl.EmployeeObjectFactory;
import src.com.fruit.test.factory.impl.FindingObjectFactory;

@Configuration
public class ObjectFactoryConfiguration {

	@Bean
	public EmployeeObjectFactory employeeObjectFactory() throws Exception {
		
		return new EmployeeObjectFactory();
	}
	
	@Bean
	public FindingObjectFactory fingdingFactory() throws Exception {
		
		return new FindingObjectFactory();
	}
}
