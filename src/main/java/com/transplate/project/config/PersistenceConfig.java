package com.transplate.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.transplate.project.repository")
public class PersistenceConfig {
	
}
