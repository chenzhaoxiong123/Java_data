package com.lanou3g.bookstore.user.web;

import com.lanou3g.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    public String login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("------");
        return "r:/index.jsp";
    }
    public String register(HttpServletRequest request,HttpServletResponse response){
        System.out.println("+++++");
        return "f:/login.jsp";
    }
}
