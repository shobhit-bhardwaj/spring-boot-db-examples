package com.shobhit;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DBConfig {

	@Bean("datasource1")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource1")
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}

	@Bean("datasource2")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}
}