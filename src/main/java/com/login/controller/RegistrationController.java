package com.login.controller;

import com.login.repository.LoginRepository;
import com.login.repository.LoginRepositoryImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration")
public class RegistrationController extends HttpServlet {
    LoginRepository loginRepository = new LoginRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/registr.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        loginRepository.addUser(login,password,name);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("name",name);
        req.getRequestDispatcher("/views/loginSucsess.jsp").forward(req,resp);
    }
}
