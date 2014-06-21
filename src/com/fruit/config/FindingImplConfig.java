package com.fruit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.fruit.DAO.impl.FindingDAOImpl;

@Configuration
@Import(value = {
		JdbcTemplateConfig.class
})
public class FindingImplConfig {

	@Bean
	public FindingDAOImpl findingDAOImpl() {
		
		return new FindingDAOImpl();
	}
}
