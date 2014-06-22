package com.fruit.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.nativejdbc.CommonsDbcpNativeJdbcExtractor;

@Configuration
@ComponentScan( basePackages = {
		"com.fruit.backend.service"
}) 
@Import( value = {
		DatasourceConfig.class,
		EmployeeImplConfig.class,
		FindingImplConfig.class
})
public class ServiceConfig {

	@Autowired
	private Environment environment;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		jdbcTemplate.setDataSource(dataSource);
		jdbcTemplate.setNativeJdbcExtractor( nativeJdbcExtractor() );
		
		return jdbcTemplate;
	}
	
	@Bean
	public CommonsDbcpNativeJdbcExtractor nativeJdbcExtractor() {
		
		return new CommonsDbcpNativeJdbcExtractor();
	}
	
//	@Bean
//	public PlatformTransactionManager transactionManager() throws IOException {
//
//		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//
//		jpaTransactionManager.setEntityManagerFactory( entityManagerFactory().getObject() );
//
//		return jpaTransactionManager;
//
//	}
//	
//	@Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws FileNotFoundException, IOException {
//
//		Properties properties = new Properties();
//
//		// make sure these properties are in the application.properties file
//		for(String property : new String[] { "hibernate.dialect", "hibernate.hbm2ddl.auto", "hibernate.ejb.naming_strategy" } ) {
//			properties.setProperty(property, this.environment.getProperty(property));
//		}
//
//		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//		jpaVendorAdapter.setDatabase( Database.DEFAULT );
//		jpaVendorAdapter.setGenerateDdl( false );
//
//		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactoryBean.setPersistenceProvider( new HibernatePersistenceProvider() );
//		entityManagerFactoryBean.setDataSource( this.dataSource );
//		entityManagerFactoryBean.setPackagesToScan("com.fruit.cpfr.backend.bean");
//		entityManagerFactoryBean.setJpaVendorAdapter( jpaVendorAdapter );
//		entityManagerFactoryBean.setJpaProperties(properties);
//		entityManagerFactoryBean.afterPropertiesSet();
//
//		return entityManagerFactoryBean;
//
//    }
//	
//	@Bean
//	public AuditorAware<String> auditorProvider() {
//		return new SpringSecurityAuditorAware();
//	}
}
