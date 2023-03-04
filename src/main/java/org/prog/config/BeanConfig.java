package org.prog.config;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class BeanConfig {

  @Bean(name = "dataSource")
  public DriverManagerDataSource dataSource() {
    DriverManagerDataSource dmds =
        new DriverManagerDataSource("jdbc:mysql://localhost:3306/db", "user", "password");
    dmds.setDriverClassName("com.mysql.jdbc.Driver");
    return dmds;
  }
}