package com.lanou3g.bookstore.user.web;

import com.lanou3g.bookstore.user.bean.User;
import com.lanou3g.bookstore.user.service.UserService;
import com.lanou3g.bookstore.user.service.exception.UserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            User login = userService.login(user);
            System.out.println(login + "++++++++");
            request.getSession().setAttribute("user",login);
            response.sendRedirect(request.getContextPath()+"jsps/main.jsp");
        } catch (SQLException e) {
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
        } catch (UserException e) {
            request.setAttribute("errorMessage",e.getMessage());
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
