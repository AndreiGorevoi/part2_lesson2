package com.login.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class LoginRepositoryImpl implements LoginRepository{
    private final JdbcTemplate jdbcTemplate;

    public LoginRepositoryImpl(@Autowired DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<String> checkUser(String login, String pass) {
        return jdbcTemplate.query(
                "select * from accounts where login="+"\""+login+"\""+" AND password=" + pass,
                new LoginrepositoryRowMapper());

    }

    @Override
    public boolean addUser(String login, String pass,String name) {
       int update=jdbcTemplate.update("Insert into accounts(login,password,name) value(?,?,?)",login,pass,name);
        return update != 0;

    }
}