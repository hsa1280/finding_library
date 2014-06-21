package com.fruit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.fruit.DAO.impl.EmployeeDAOImpl;

@Configuration

@Import( value = {
		JdbcTemplateConfig.class
})
public class EmployeeImplConfig {

	@Bean
	public EmployeeDAOImpl employeeImpl() {
		
		return new EmployeeDAOImpl();
	}
}
