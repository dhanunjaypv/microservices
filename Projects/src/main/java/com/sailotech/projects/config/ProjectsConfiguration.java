package com.sailotech.projects.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectsConfiguration {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
