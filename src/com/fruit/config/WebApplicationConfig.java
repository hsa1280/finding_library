package com.fruit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan( "com.fruit.frontend.controller" )
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver internalViewResourceResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix( "/WEB-INF/jsp/" );
		resolver.setSuffix( ".jsp" );
		
		return resolver;
		
	}
}
