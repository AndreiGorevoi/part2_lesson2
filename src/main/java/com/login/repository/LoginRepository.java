package com.login.repository;

import java.util.List;

public interface LoginRepository {
    List<String> checkUser(String name, String pass);
    boolean addUser(String login, String pass,String name);
}
