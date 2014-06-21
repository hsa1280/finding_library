package com.fruit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Import( value = {
		DatasourceConfig.class,
})
public class JdbcTemplateConfig {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDatasource());
		
		return jdbcTemplate;
		
	}

	public DataSource getDatasource() {
		return dataSource;
	}

	public void setDatasourceConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
}
