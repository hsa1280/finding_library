package com.fruit.config;

import javax.sql.DataSource;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class DatasourceConfig {

//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	
//	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	
//	private String userName = "Findings_Library";
//	
//	private String passWord = "password";
	
	@Value( "${db.url}")
	private String url;
	
	@Value( "${db.user}")
	private String userName;
	
	@Value( "${db.password}")
	private String passWord;
	
	@Value( "${db.driver}")
	private String driver;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public DataSource dataSource() throws Exception {
		
		PoolDataSource dataSource = PoolDataSourceFactory.getPoolDataSource();
		
		dataSource.setConnectionFactoryClassName(this.driver);
		dataSource.setURL(this.url);
		dataSource.setUser(this.userName);
		dataSource.setPassword(this.passWord);
		
		return dataSource;
		
	}
}
