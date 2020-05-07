package com.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:BaseCon.properties")
public class BaseConfig  {

    @Autowired
    Environment environment;

    @Bean
    DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(environment.getProperty("url"));
        ds.setUsername(environment.getProperty("login"));
        ds.setPassword(environment.getProperty("password"));
        return ds;
    }

}
