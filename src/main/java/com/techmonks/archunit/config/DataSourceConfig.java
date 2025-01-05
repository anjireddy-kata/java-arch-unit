package com.techmonks.archunit.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.techmonks.archunit.repository")
public class DataSourceConfig {
}
