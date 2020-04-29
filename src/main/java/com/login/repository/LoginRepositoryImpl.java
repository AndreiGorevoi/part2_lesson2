package com.login.repository;

import java.sql.*;

public class LoginRepositoryImpl implements LoginRepository{

    @Override
    public String checkUser(String login, String pass) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts?useUnicode=true&serverTimezone=UTC",
                "root","veronikagorevaya1994")){
            String sql = "select * from accounts where login=?";
            String tempPass="";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,login);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tempPass = rs.getString(3);
                if(tempPass.equalsIgnoreCase(pass)){
                    return rs.getString(4);
                }
            }else return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser(String login, String pass,String name) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts?useUnicode=true&serverTimezone=UTC",
                "root","veronikagorevaya1994")){
            String sql = "Insert into accounts(login,password,name) value(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,login);
            ps.setString(2,pass);
            ps.setString(3,name);
            ps.execute();
            return true;
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}