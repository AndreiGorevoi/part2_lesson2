package com.login.controller;

import com.login.repository.LoginRepository;
import com.login.repository.LoginRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private LoginRepository loginRepository = new LoginRepositoryImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String login = req.getParameter("login");
    String pass = req.getParameter("password");
    String name = loginRepository.checkUser(login,pass);
    if(name!=null){
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("name",name);
        req.getRequestDispatcher("/views/loginSucsess.jsp").forward(req,resp);
    }else {
        req.getRequestDispatcher("/views/registr.jsp").forward(req,resp);
    }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String locale = req.getParameter("lang");
        locale = Objects.nonNull(locale) ? locale:"en";
        switch (locale){
            case ("de"):
                Locale.setDefault(Locale.GERMAN);
                break;
            case ("it"):
                Locale.setDefault(Locale.ITALIAN);
                break;
            default:
                Locale.setDefault(Locale.ENGLISH);
        }
        req.setAttribute("lang", Locale.getDefault());
        req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
    }
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

