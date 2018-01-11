package com.lanou3g.bookstore.book.web;

import com.lanou3g.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BooksServlet",urlPatterns = "/books")
public class BooksServlet extends BaseServlet {

    public String all(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("111111111111");
        return "f:/jsps/book/list.jsp";
    }
}
