/*
 * package com.twitter.demo.config;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.beans.factory.annotation.Value;
 * import org.springframework.context.annotation.Bean;
 * import org.springframework.context.annotation.Configuration;
 * import org.springframework.jdbc.datasource.DriverManagerDataSource;
 * 
 * @Configuration
 * public class DatabaseConfig {
 * 
 * @Autowired
 * 
 * @Value("${DATABASE_URL_SpringP}")
 * private String databaseUrl;
 * 
 * @Autowired
 * 
 * @Value("${DATABASE_USERNAME_SpringP}")
 * private String databaseUsername;
 * 
 * @Autowired
 * 
 * @Value("${DATABASE_PASSWORD_SpringP}")
 * private String databasePassword;
 * 
 * @Bean
 * public DataSource dataSource() {
 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
 * dataSource.setUrl(databaseUrl);
 * dataSource.setUsername(databaseUsername);
 * dataSource.setPassword(databasePassword);
 * return dataSource;
 * }
 * }
 * para el local
 */