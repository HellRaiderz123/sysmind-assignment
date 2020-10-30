package com.sysmind.org.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages="com.sysmind.org")
@EnableWebMvc
public class MvcConfiguration{
	
	//similar web.xml like configuration will be done in MvcConfigurationInitializer class

}
