package com.login.repository;

public interface LoginRepository {
    String checkUser(String name, String pass);
    boolean addUser(String login, String pass,String name);
}
